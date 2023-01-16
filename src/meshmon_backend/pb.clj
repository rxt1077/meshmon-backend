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
;; the `declare` prevents "Unresolved Symbol" linter errors
(declare to-radio-mapper)
(pronto/defmapper to-radio-mapper [MeshProtos$ToRadio]
  :key-name-fn utils/->kebab-case)
(declare from-radio-mapper)
(pronto/defmapper from-radio-mapper [MeshProtos$FromRadio]
  :key-name-fn utils/->kebab-case)
(declare telemetry-mapper)
(pronto/defmapper telemetry-mapper [TelemetryProtos$Telemetry]
  :key-name-fn utils/->kebab-case)
(declare user-mapper)
(pronto/defmapper user-mapper [MeshProtos$User]
  :key-name-fn utils/->kebab-case)
(declare position-mapper)
(pronto/defmapper position-mapper [MeshProtos$Position]
  :key-name-fn utils/->kebab-case)
(declare mesh-packet-mapper)
(pronto/defmapper mesh-packet-mapper [MeshProtos$MeshPacket]
  :key-name-fn utils/->kebab-case)
(declare data-mapper)
(pronto/defmapper data-mapper [MeshProtos$Data]
  :key-name-fn utils/->kebab-case)
(declare response-mapper)
(pronto/defmapper response-mapper [Meshmon$Response]
  :key-name-fn utils/->kebab-case)
(declare row-mapper)
(pronto/defmapper row-mapper [Meshmon$Row]
  :key-name-fn utils/->kebab-case)

(defn clj-map->row
  "Creates a Row proto-map from the given clj map"
  [m] 
  (pronto/clj-map->proto-map row-mapper Meshmon$Row m))

(defn clj-map->response
  "Creates a Response proto-map from the given clj map"
  [m]
  (pronto/clj-map->proto-map response-mapper Meshmon$Response m))

(defn clj-map->data
  "Creates a Data proto-map from the given clj map"
  [m]
  (pronto/clj-map->proto-map data-mapper MeshProtos$Data m))

(defn clj-map->position
  "Creates a Position proto-map from the given clj map"
  [m]
  (pronto/clj-map->proto-map position-mapper MeshProtos$Position m))

(defn clj-map->mesh-packet
  "Creates a MeshPacket proto-map from the given clj map"
  [m]
  (pronto/clj-map->proto-map mesh-packet-mapper MeshProtos$MeshPacket m))

(defn clj-map->to-radio
  "Creates a ToRadio proto-map from the given clj map"
  [m]
  (pronto/clj-map->proto-map to-radio-mapper MeshProtos$ToRadio m))

(defn bytes->from-radio
  "Creates a FromRadio proto-map from the given bytes"
  [b]
  (pronto/bytes->proto-map from-radio-mapper MeshProtos$FromRadio b))

(defn bytes->mesh-packet
  "Creates a MeshPacket proto-map from the given bytes"
  [b]
  (pronto/bytes->proto-map mesh-packet-mapper MeshProtos$MeshPacket b))

(defn proto-map->bytes
  "Converts a proto-map to bytes"
  [protobuf]
  (pronto/proto-map->bytes protobuf))

(defn fix-ints
  "Makes sure all integers in a map are unsigned"
  [mesh-packet]
  (reduce-kv
    (fn [m k v]
      (if (integer? v)
        (assoc m k (bit-and 0xffffffff v))
        (assoc m k v)))
    {}
    mesh-packet))

(defn from-radio->mesh-packet
  "Creates a MeshPacket proto-map from a FromRadio proto-map, correcting the
  integers. Returns nil if there is no packet in the FromRadio."
  [from-radio]
  (when-let [mesh-packet (:packet from-radio)]
    (fix-ints mesh-packet)))
