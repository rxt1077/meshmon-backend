(ns meshmon-backend.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [next.jdbc :as jdbc]
            [next.jdbc.result-set :as result-set]
            [clojure.data.json :as json]
            [ring.adapter.jetty :as ring-jetty]
            [clojure.tools.cli :refer [parse-opts]]
            [taoensso.timbre :as timbre]
            [meshmon-backend.serial :as serial]
            [meshmon-backend.db :as db]
            [meshmon-backend.web :as web])
  (:gen-class))

(defn print-usage [summary]
  (println (str "\nUsage is meshmon-backend [options]\n\nOptions:\n" summary)))

(def cli-options
  [["-r" "--record" "record packets from device"]
   ["-s" "--serial PORT"
    "use serial PORT for recording (autodetects if not specified)"]
   ["-p" "--port PORTNUM"
    "TCP port for HTTP connections"
    :default 5000]
   ["-t" "--static DIR"
    "static files directory"
    :default "./static"]
   ["-u" "--url URL"
    "jdbc URL for database"
    :default "jdbc:sqlite:packets.db"]
   ["-l" "--log-level LEVEL"
    "minimum logging level"
    :default "info"]
   ["-h"
    "--help"
    "display this help message"]])

(defn -main [& args]
  (let [opts (parse-opts args cli-options)
        errors (:errors opts)
        options (:options opts)
        help (:help options)
        record (:record options)
        serial-port (:serial options)
        port (:port options)
        url (:url options)
        static (:static options)
        log-level (:log-level options)]
    (cond
      errors (doall (map #(println %) errors))
      help (print-usage (:summary opts))
      :default
      (let [_ (timbre/set-min-level!
                (keyword (clojure.string/lower-case log-level)))
            ds (db/start url)
            app (web/app ds static)
            _ (if record (serial/start! serial-port ds))]
          (ring-jetty/run-jetty app {:port port})))))
