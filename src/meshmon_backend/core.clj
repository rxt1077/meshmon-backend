(ns meshmon-backend.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [next.jdbc :as jdbc]
            [next.jdbc.result-set :as result-set]
            [clojure.data.json :as json]
            [camel-snake-kebab.core :as csk]
            [ring.adapter.jetty :as ring-jetty])
  (:gen-class))

(def db {:jdbcUrl (or (System/getenv "DATABASE_URL") "jdbc:sqlite:packets.db")})

(def ds (jdbc/get-datasource db))

(defn as-unqualified-camel-maps [rs opts]
  "Result set builder that converts keys to camel case"
  (result-set/as-unqualified-modified-maps
    rs (assoc opts :qualifier-fn csk/->camelCase :label-fn csk/->camelCase)))

(defn query->json-response [query-vec]
  "Performs a query and returns the result as a JSON response"
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json/write-str (jdbc/execute!
                           ds query-vec
                           {:builder-fn as-unqualified-camel-maps}))})

(def base-query "SELECT packet_from, packet_to, decoded, id, rx_time, rx_snr,
hop_limit, rx_rssi, channel, want_ack, priority, delayed, port, rowid FROM
packets ")

(defroutes app-routes
  ;; all packets
  (GET "/packets" []
       (query->json-response [(str base-query ";")]))
  ;; all packets after a certain rowid
  (GET "/packets/after/:id{[0-9]+}" [id]
       (query->json-response [(str base-query "WHERE rowid > ?;") id]))
  ;; one packet (still in a list) after a certain rowid
  (GET "/packets/one-after/:id{[0-9]+}" [id]
       (query->json-response [(str base-query "WHERE rowid > ? LIMIT 1;") id]))
  ;; packets with a range of rx_times (inclusive)
  (GET "/packets/range/:start{[0-9]+}-:end{[0-9]+}" [start end]
       (query->json-response
         [(str base-query "WHERE rx_time >= ? AND rx_time <= ?;") start end]))
  (route/files "/" {:root (or (System/getenv "FILES_PATH") "./static")})
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn -main [& args]
  (let [port (Integer. (or (System/getenv "PORT") "3000"))]
    (ring-jetty/run-jetty app {:port port})))
