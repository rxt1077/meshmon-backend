(ns meshmon-backend.web
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.cors :refer [wrap-cors]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [taoensso.timbre :as timbre]
            [ring.logger :as logger]
            [meshmon-backend.db :as db]
            [meshmon-backend.pb :as pb]
            [clojure.data.json :as json]))

(defn response [rows]
  "Returns the rows as a protobuf response"
  {:status 200
   :headers {"Content-Type" "application/x-protobuf"}
   :body (pb/proto-map->bytes (pb/clj-map->response {:rows rows}))})

(defn app-routes [ds static]
  (routes
    (GET "/packets" []
         (response (db/get-all ds)))
    (GET "/packets/after/:id{[0-9]+}" [id]
         (response (db/get-after ds id)))
    (GET "/packets/one-after/:id{[0-9]+}" [id]
         (response (db/get-one-after ds id)))
    (GET "/packets/range/:start{[0-9]+}-:end{[0-9]+}" [start end]
         (response (db/get-range ds start end)))
    (route/files "/" {:root static})
    (route/not-found "Not Found")))

(defn app [ds static]
  "Returns the ring app for our web API"
  (-> (app-routes ds static)
      (wrap-defaults site-defaults)
      (wrap-cors :access-control-allow-origin [#".*"]
                 :access-control-allow-methods [:get])
      (logger/wrap-log-response
        {:log-fn (fn [{:keys [level throwable message]}]
                   (timbre/log level throwable message))})))
