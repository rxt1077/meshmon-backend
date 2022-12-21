(ns meshmon-backend.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.result-set :as result-set]
            [clojure.data.json :as json]
            [meshmon-backend.pb :as pb]))

(defn query->edn-response [ds query-vec]
  "Performs a query and returns the result as a JSON response"
  {:status 200
   :headers {"Content-Type" "application/edn"}
   :body (pr-str (jdbc/execute!
                           ds query-vec
                           {:builder-fn result-set/as-unqualified-kebab-maps}))})

(defn save-mesh-packet! [ds mesh-packet]
  "Saves a MeshPacket to the database. The decoded field is converted to an EDN
  string"
  (jdbc/execute! ds ["INSERT INTO packets (
                     packet_from,
                     packet_to,
                     decoded,
                     id,
                     rx_time,
                     rx_snr,
                     hop_limit,
                     rx_rssi,
                     channel,
                     want_ack,
                     priority,
                     delayed,
                     port)
                     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
                     (:from mesh-packet)
                     (:to mesh-packet)
                     (pr-str (pb/payload->proto-map mesh-packet))
                     (:id mesh-packet)
                     (:rx-time mesh-packet)
                     (:rx-snr mesh-packet)
                     (:hop-limit mesh-packet)
                     (:rx-rssi mesh-packet)
                     (:channel mesh-packet)
                     (:want-ack mesh-packet)
                     (:priority mesh-packet)
                     (:delayed mesh-packet)
                     (:portnum (:decoded mesh-packet))]))

(defn start [jdbc-url]
  "Gets the datasource for the DB based on the URL given. Creates the packets
  table if it doesn't exist."
  (let [ds (jdbc/get-datasource {:jdbcUrl jdbc-url})
        query-vec ["CREATE TABLE IF NOT EXISTS packets (
                   rowid INTEGER PRIMARY KEY,
                   packet_from INTEGER,
                   packet_to INTEGER,
                   decoded TEXT,
                   id INTEGER,
                   rx_time INTEGER,
                   rx_snr REAL,
                   hop_limit INTEGER,
                   rx_rssi INTEGER,
                   channel INTEGER,
                   want_ack INTEGER,
                   priority TEXT,
                   delayed TEXT,
                   port TEXT);"]]
    (do
      (jdbc/execute! ds query-vec)
      ds)))
