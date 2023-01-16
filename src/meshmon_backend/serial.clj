(ns meshmon-backend.serial
  (:require [serial.util :as util]
            [serial.core :as serial]
            [clojure.core.async :refer [go-loop <! timeout]]
            [taoensso.timbre :as timbre :refer [trace debug]]
            [meshmon-backend.pb :as pb]
            [meshmon-backend.db :as db]))

;; magic numbers used to signal the start of a protobuf sent via serial
(def start-1 (unchecked-byte 0x94))
(def start-2 (unchecked-byte 0xC3))

;; start-packet uses a nonce to confirm a valid connection
(def nonce (rand-int 0x7FFFFFFF))

;; this packet signals the start of a serial connection with the device
(def start-packet (pb/clj-map->to-radio {:want-config-id nonce}))

(defn bytes->str
  "Convert a byte-array to a formatted hex string"
  [bt-array]
  (let [byte-strs (map #(format "0x%02x " %) bt-array)
        ;; add a newline every 16 hex characters (and at the start)
        newlines (reduce
                   (fn [out byte-str]
                     (if (= (mod (count out) 17) 0)
                       (into out ["\n" byte-str])
                       (conj out byte-str)))
                   [] byte-strs)]
    (apply str newlines)))

(defn proto-map->stream
  "Creates a stream byte-array from the given proto-map"
  [protobuf]
  (let [proto-bytes (pb/proto-map->bytes protobuf)
        length (alength proto-bytes)
        size-1 (byte (bit-and (bit-shift-right length 8) 0xFF))
        size-2 (byte (bit-and length 0xFF))]
    (byte-array (concat [start-1 start-2 size-1 size-2] proto-bytes))))

(defn pb-size
  "Gives the size of the protobuf from the second and third bytes of a packet."
  [pkt]
  (+ (bit-shift-left (bit-and 0xff (nth pkt 2)) 8) (bit-and 0xff (nth pkt 3))))

;; this is an empty ToRadio packet used to keep the device awake
(def heatbeat-packet (pb/clj-map->to-radio {}))
(defn heartbeat-timer
  "Uses core.async to run in the background sending a heartbeat every
  `interval` seconds"
  [port interval]
  (go-loop []
    (do
      (debug "Sending heartbeat")
      (serial/write port (proto-map->stream heatbeat-packet))
      (<! (timeout (* interval 1000))) (recur))))


(def packet (atom []))
(defn fsm!
  "Finite state machine for serial communication. This function is fed the
  serial stream one byte at a time and it uses the packet Atom to maintain
  state. It returns nil until and full packet it received then it returns
  the packet. Details on the protocol can be found here:
  https://meshtastic.org/docs/development/device/client-api

  If `print-noproto` is true, non-protobuf characters will be printed if
  recieved. Trace level debug output is available to show byte-by-byte
  what is happening."
  ([new-byte] (fsm! new-byte false))
  ([new-byte print-noproto]
   (let [pkt @packet
         len (count pkt)
         _ (trace "new-byte:" (format "0x%02x" new-byte))
         _ (trace "packet:" (bytes->str pkt))]
     (cond
       ;; waiting for a start-1 byte
       (= len 0)
       (if (= new-byte start-1)
         (do
           (trace "Received start-1")
           (swap! packet conj new-byte)
           nil)
         (if print-noproto (print (char (bit-and 0xff new-byte))) nil))

       ;; waiting for a start-2 byte
       (= len 1)
       (if (= new-byte start-2)
         (do
           (trace "Received start-2")
           (swap! packet conj new-byte)
           nil)
         (do
           (reset! packet [])
           (println "Expecting start-2, received" (format "0x%02x " new-byte))))

       ;; reading size bytes (should we check the 512 limit?)
       (< len 4)
       (do
         (trace "Reading size")
         (swap! packet conj new-byte)
         nil)

       ;; reading protobuf bytes
       :else
       (let [pkt (swap! packet conj new-byte)
             proto-size (pb-size pkt)
             proto (vec (drop 4 pkt)) ;; pull off the header bytes
             curr-size (count proto)]
         (trace "Reading protobuf bytes (read"
                (format "0x%02x" curr-size) "so far)")
         (if (>= curr-size proto-size)
           (do
             (trace "Done")
             (reset! packet [])
             (byte-array proto))
           nil))))))

(defn input-handler
  "Called when serial input is available, reads it one byte at a time and sends
  it to the FSM. We do this one byte at a time, because if we read into a
  buffer it fills with 0x00 bytes if nothing is available.

  PowerConfig is used to setup a heartbeat timer.  
  MeshPackets are sent to be written to the DB."
  [^java.io.InputStream is port ds]
  (when-let [serial-pkt (fsm! (unchecked-byte (.read is)))]
    (let [from-radio (pb/bytes->from-radio serial-pkt)]
      (debug "Recieved from device:" from-radio)
      (cond
        ;; if we get a power config, set the heartbeat to ls-secs / 2
        (:config from-radio)
        (when-let [power (:power (:config from-radio))]
          (when-let [ls-secs (:ls-secs power)]
            (let [interval (/ ls-secs 2)]
              (debug "Sending heartbeats every" interval "seconds")
              (heartbeat-timer port interval))))

        ;; otherwise if we get a mesh-packet save it
        (:packet from-radio)
        (db/save-mesh-packet! ds (:packet from-radio))))))

(defn open-first-working-port
  "Goes through all possible ports that are either ttyUSB or ttyACM and
  opens the returns the first one that can be opened. If there is an exception
  it tries the next port."
  ([]
   (let [port-names (filter #(re-matches #"(ttyUSB|ttyACM)[0-9]+" %)
                            (util/get-port-names))]
     (open-first-working-port port-names)))
  ([port-names]
   (if (empty? port-names)
     nil
     (let [port-name (first port-names)]
       (try
         (println "Opening" port-name)
         (serial/open port-name)
         (catch Exception e
             (do
               (println "Exception:" (.getMessage e))
               (open-first-working-port (rest port-names)))))))))

(defn start!
  "Opens the specified port-name or the first working serial port if passed nil.
  Sets up a listener to write incoming packets to the database and writes the
  start-packet. Returns the port."
  [port-name ds]
  (let [port (if port-name (serial/open port-name) (open-first-working-port))]
    (if port
      (do
        (serial/listen! port #(input-handler % port ds))
        (serial/write port (proto-map->stream start-packet))
        port)
      (println "No serial ports found. Not recording."))))

(defn stop!
  "Closes the serial port"
  [port]
  (serial/close! port))
