(ns meshmon-backend.web
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.cors :refer [wrap-cors]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [meshmon-backend.db :as db]))

(def base-query "SELECT packet_from, packet_to, decoded, id, rx_time, rx_snr,
hop_limit, rx_rssi, channel, want_ack, priority, delayed, port, rowid FROM
packets ")

(defn app-routes [ds static]
  (routes
    ;; all packets
    (GET "/packets" [] (db/query->edn-response ds [(str base-query ";")]))
    ;; all packets after a certain rowid
    (GET "/packets/after/:id{[0-9]+}" [id]
         (db/query->edn-response ds [(str base-query "WHERE rowid > ?;") id]))
    ;; one packet (still in a list) after a certain rowid
    (GET "/packets/one-after/:id{[0-9]+}" [id]
         (db/query->edn-response
           ds [(str base-query "WHERE rowid > ? LIMIT 1;") id]))
    ;; packets with a range of rx_times (inclusive)
    (GET "/packets/range/:start{[0-9]+}-:end{[0-9]+}" [start end]
         (db/query->edn-response ds
           [(str base-query "WHERE rx_time >= ? AND rx_time <= ?;") start end]))
    (route/files "/" {:root static})
    (route/not-found "Not Found")))

(defn app [ds static]
  "Returns the ring app for our web API"
  (-> (app-routes ds static)
      (wrap-defaults site-defaults)
      (wrap-cors :access-control-allow-origin [#".*"]
                 :access-control-allow-methods [:get])))
