(ns meshmon-backend.pb
  "Functions for dealing with MeshTastic protobufs. Mostly a thin abstraction
  over pronto."
  (:require [pronto.core :as pronto]
            [pronto.utils :as utils])
  (:import com.geeksville.mesh.MeshProtos$ToRadio
           com.geeksville.mesh.MeshProtos$FromRadio
           com.geeksville.mesh.TelemetryProtos$Telemetry
           com.geeksville.mesh.MeshProtos$User
           com.geeksville.mesh.MeshProtos$Position
           com.geeksville.mesh.MeshProtos$MeshPacket
           com.geeksville.mesh.MeshProtos$Data
           com.geeksville.mesh.Meshmon$Row
           com.geeksville.mesh.Meshmon$Response))

;; pronto mappers for protobufs
(pronto/defmapper to-radio-mapper [MeshProtos$ToRadio]
  :key-name-fn utils/->kebab-case)
(pronto/defmapper from-radio-mapper [MeshProtos$FromRadio]
  :key-name-fn utils/->kebab-case)
(pronto/defmapper telemetry-mapper [TelemetryProtos$Telemetry]
  :key-name-fn utils/->kebab-case)
(pronto/defmapper user-mapper [MeshProtos$User]
  :key-name-fn utils/->kebab-case)
(pronto/defmapper position-mapper [MeshProtos$Position]
  :key-name-fn utils/->kebab-case)
(pronto/defmapper mesh-packet-mapper [MeshProtos$MeshPacket]
  :key-name-fn utils/->kebab-case)
(pronto/defmapper data-mapper [MeshProtos$Data]
  :key-name-fn utils/->kebab-case)
(pronto/defmapper response-mapper [Meshmon$Response]
  :key-name-fn utils/->kebab-case)
(pronto/defmapper row-mapper [Meshmon$Row]
  :key-name-fn utils/->kebab-case)

(defn clj-map->row [m]
  "Creates a Row proto-map from the given clj map"
  (pronto/clj-map->proto-map row-mapper Meshmon$Row m))

(defn clj-map->response [m]
  "Creates a Response proto-map from the given clj map"
  (pronto/clj-map->proto-map response-mapper Meshmon$Response m))

(defn clj-map->data [m]
  "Creates a Data proto-map from the given clj map"
  (pronto/clj-map->proto-map data-mapper MeshProtos$Data m))

(defn clj-map->position [m]
  "Creates a Position proto-map from the given clj map"
  (pronto/clj-map->proto-map position-mapper MeshProtos$Position m))

(defn clj-map->mesh-packet [m]
  "Creates a MeshPacket proto-map from the given clj map"
  (pronto/clj-map->proto-map mesh-packet-mapper MeshProtos$MeshPacket m))

(defn clj-map->to-radio [m]
  "Creates a ToRadio proto-map from the given clj map"
  (pronto/clj-map->proto-map to-radio-mapper MeshProtos$ToRadio m))

(defn bytes->from-radio [b]
  "Creates a FromRadio proto-map from the given bytes"
  (pronto/bytes->proto-map from-radio-mapper MeshProtos$FromRadio b))

(defn bytes->telemetry [b]
  "Creates a Telemetry proto-map from the given bytes"
  (pronto/bytes->proto-map telemetry-mapper TelemetryProtos$Telemetry b))

(defn bytes->user [b]
  "Creates a User proto-map from the given bytes"
  (pronto/bytes->proto-map user-mapper MeshProtos$User b))

(defn bytes->position [b]
  "Creates a Position proto-map from the given bytes"
  (pronto/bytes->proto-map position-mapper MeshProtos$Position b))

(defn bytes->mesh-packet [b]
  "Creates a MeshPacket proto-map from the given bytes"
  (pronto/bytes->proto-map mesh-packet-mapper MeshProtos$MeshPacket b))

(defn proto-map->bytes [protobuf]
  "Converts a proto-map to bytes"
  (pronto/proto-map->bytes protobuf))

(defn fix-ints [mesh-packet]
  "Makes sure all integers in a map are unsigned"
  (reduce-kv
    (fn [m k v]
      (if (integer? v)
        (assoc m k (bit-and 0xffffffff v))
        (assoc m k v)))
    {}
    mesh-packet))

(defn payload->proto-map [mesh-packet]
  "Takes a MeshPacket and returns a proto-map of its payload. If the payload
  cannot be decoded it returns nil."
  (let [decoded (:decoded mesh-packet)
        payload (byte-array (:payload decoded))
        portnum (:portnum decoded)]
    (case portnum
      :TELEMETRY_APP (bytes->telemetry payload)
      :NODEINFO_APP (bytes->user payload)
      :POSITION_APP (bytes->position payload)
      nil)))

(defn from-radio->mesh-packet [from-radio]
  "Creates a MeshPacket proto-map from a FromRadio proto-map, correcting the
  integers. Returns nil if there is no packet in the FromRadio."
  (when-let [mesh-packet (:packet from-radio)]
    (fix-ints mesh-packet)))
