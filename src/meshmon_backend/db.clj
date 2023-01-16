(ns meshmon-backend.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.result-set :as result-set]
            [meshmon-backend.pb :as pb]))

(defn query
  "Performs a query and returns it as a vector of Row proto-maps with MeshPacket
  proto-maps inside them"
  [ds query-vec]
  (mapv
    #(pb/clj-map->row (assoc % :packet (pb/bytes->mesh-packet (:packet %))))
    (jdbc/execute! ds query-vec
                   {:builder-fn result-set/as-unqualified-kebab-maps})))

(defn get-all
  "Gets all the packets in the DB"
  [ds]
  (query ds ["SELECT * FROM packets;"]))

(defn get-after
  "Gets all the packets after a certain rowid in the DB"
  [ds rowid]
  (query ds ["SELECT * FROM packets WHERE rowid > ?;" rowid]))

(defn get-one-after
  "Gets a single packet (still in a list) after a certain rowid"
  [ds rowid]
  (query ds ["SELECT * FROM packets WHERE rowid > ? LIMIT 1;" rowid]))

(defn get-range
  "Gets packets within a range of rx_times (inclusive)"
  [ds start end]
  (query ds ["SELECT * FROM packets WHERE rx_time >= ? AND rx_time <=?;"
             start end]))

(defn save-mesh-packet!
  "Saves a MeshPacket proto-map to the database."
  [ds mesh-packet]
  (jdbc/execute! ds ["INSERT INTO packets (rx_time, packet) VALUES (?, ?)"
                     (:rx-time mesh-packet)
                     (pb/proto-map->bytes mesh-packet)]))

(defn start
  "Gets the datasource for the DB based on the URL given. Creates the packets
  table if it doesn't exist."
  [jdbc-url]
  (let [ds (jdbc/get-datasource {:jdbcUrl jdbc-url})
        query-vec ["CREATE TABLE IF NOT EXISTS packets (
                   rowid INTEGER PRIMARY KEY,
                   rx_time INTEGER,
                   packet BLOB);"]]
    (jdbc/execute! ds query-vec)
    ds))
