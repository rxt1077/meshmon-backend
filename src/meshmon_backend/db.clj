(ns meshmon-backend.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.result-set :as result-set]
            [clojure.data.json :as json]
            [meshmon-backend.pb :as pb]
            [clojure.data.json :as json]
            [camel-snake-kebab.core :as csk]
            [taoensso.timbre :as timbre :refer [trace debug]]
            [clojure.set :refer [rename-keys]]
            [clojure.string :refer [starts-with?]]))

;;(defn fix-labels [row]
;;  "Fix the names of some labels in a row"
;;  (rename-keys row
;;               {:packet-from :from
;;                :packet-to :to}))
;;
;;(defn fix-bools [row]
;;  "Convert 0 and 1 int values to boolean values"
;;  (assoc row :want-ack (= 1 (:want-ack row))))
;;
;;(defn fix-keywords [row]
;;  "Convert any string value that starts with ':' to a label. Enums are labels
;;  but sqlite stores them as strings."
;;  (reduce-kv
;;    (fn [m k v]
;;      (if (starts-with? v ":") (assoc m k (keyword v)) (assoc m k v)))
;;    {}
;;    row))

(defn query [ds query-vec]
  "Performs a query and returns it as a vector of Row proto-maps with MeshPacket
  proto-maps inside them"
  (mapv
    #(pb/clj-map->row (assoc % :packet (pb/bytes->mesh-packet (:packet %))))
    (jdbc/execute! ds query-vec
                   {:builder-fn result-set/as-unqualified-kebab-maps})))

(defn get-all [ds]
  "Gets all the packets in the DB"
  (query ds ["SELECT * FROM packets;"]))

(defn get-after [ds rowid]
  "Gets all the packets after a certain rowid in the DB"
  (query ds ["SELECT * FROM packets WHERE rowid > ?;" rowid]))

(defn get-one-after [ds rowid]
  "Gets a single packet (still in a list) after a certain rowid"
  (query ds ["SELECT * FROM packets WHERE rowid > ? LIMIT 1;" rowid]))

(defn get-range [ds start end]
  "Gets packets within a range of rx_times (inclusive)"
  (query ds ["SELECT * FROM packets WHERE rx_time >= ? AND rx_time <=?;"
             start end]))

;;(defn value-fn [k v]
;;  "Not all types used by Pronto are easily encoded to JSON. This function fixes
;;  the problematic types."
;;  (case k
;;    :macaddr (str (interpose ":" (map #(format "%02x" %) v)))
;;    v))

(defn save-mesh-packet! [ds mesh-packet]
  "Saves a MeshPacket proto-map to the database."
  (jdbc/execute! ds ["INSERT INTO packets (rx_time, packet) VALUES (?, ?)"
                     (:rx-time mesh-packet)
                     (pb/proto-map->bytes mesh-packet)]))

(defn start [jdbc-url]
  "Gets the datasource for the DB based on the URL given. Creates the packets
  table if it doesn't exist."
  (let [ds (jdbc/get-datasource {:jdbcUrl jdbc-url})
        query-vec ["CREATE TABLE IF NOT EXISTS packets (
                   rowid INTEGER PRIMARY KEY,
                   rx_time INTEGER,
                   packet BLOB);"]]
    (do
      (jdbc/execute! ds query-vec)
      ds)))
