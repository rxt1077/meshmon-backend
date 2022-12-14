(ns meshmon-backend.serial
  (:require [serial.util :as util]
            [serial.core :as serial]
            [clojure.java [io :as io]]
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

(defn bytes->str [bt-array]
  "Convert a byte-array to a formatted hex string"
  (let [byte-strs (map #(format "0x%02x " %) bt-array)
        ;; add a newline every 16 hex characters (and at the start)
        newlines (reduce
                   (fn [out byte-str]
                     (if (= (mod (count out) 17) 0)
                       (into out ["\n" byte-str])
                       (conj out byte-str)))
                   [] byte-strs)]
    (apply str newlines)))

(defn proto-map->stream [protobuf]
  "Creates a stream byte-array from the given proto-map"
  (let [proto-bytes (pb/proto-map->bytes protobuf)
        length (alength proto-bytes)
        size-1 (byte (bit-and (bit-shift-right length 8) 0xFF))
        size-2 (byte (bit-and length 0xFF))]
    (byte-array (concat [start-1 start-2 size-1 size-2] proto-bytes))))

(defn pb-size [pkt]
  "Gives the size of the protobuf from the second and third bytes of a packet."
  (+ (bit-shift-left (bit-and 0xff (nth pkt 2)) 8) (bit-and 0xff (nth pkt 3))))

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
         (if print-noproto (print (char (bit-and 0xff new-byte)))))

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
       :default
       (let [pkt (swap! packet conj new-byte)
             proto-size (pb-size pkt)
             proto (vec (drop 4 pkt)) ;; pull off the header bytes
             curr-size (count proto)]
         (do
           (trace "Reading protobuf bytes (read"
                      (format "0x%02x" curr-size) "so far)")
           (if (>= curr-size proto-size) 
            (do
              (trace "Done")
              (reset! packet [])
              (byte-array proto)))))))))

(defn input-handler [^java.io.InputStream is ds]
  "Called when serial input is available, reads it one byte at a time and sends
  it to the FSM. We do this one byte at a time, because if we read into a
  buffer it fills with 0x00 bytes if nothing is available.
  
  MeshPackets are sent to be written to the DB."
  (when-let [serial-pkt (fsm! (unchecked-byte (.read is)))]
    (when-let [mesh-packet (-> serial-pkt
                               pb/bytes->from-radio
                               pb/from-radio->mesh-packet)]
      (do
        (debug "Recieved from device:" mesh-packet)
        (db/save-mesh-packet! ds mesh-packet)))))

(defn open-first-working-port
  "Goes through all possible ports that are either ttyUSB or ttyACM and
  opens the returns the first one that can be opened. If there is an exception
  it tries the next port."
  ([]
   (let [port-names (filter #(re-matches #"(ttyUSB|ttyACM)[0-9]+" %)
                            (util/get-port-names))]
     (if (not-empty port-names)
       (open-first-working-port port-names))))
  ([port-names]
   (if (empty? port-names)
     nil
     (let [port-name (first port-names)]
       (try
         (do
           (println "Opening" port-name)
           (serial/open port-name))
         (catch Exception e
             (do
               (println "Exception:" (.getMessage e))
               (open-first-working-port (rest port-names)))))))))

(defn start! [port-name ds]
  "Opens the specified port-name or the first working serial port if passed nil.
  Sets up a listener to write incoming packets to the database and writes the
  start-packet. Returns the port."
  (let [port (if port-name (serial/open port-name) (open-first-working-port))]
    (if port
      (do
        (serial/listen! port #(input-handler % ds))
        (serial/write port (proto-map->stream start-packet))
        port)
      (println "No serial ports found. Not recording."))))

(defn stop! [port]
  "Closes the serial port"
  (serial/close! port))
