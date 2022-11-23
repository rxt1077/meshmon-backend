(defproject meshmon-backend "0.1.0"
  :description "Backend for MeshMon that serves packets from a sqlite3 database"
  :url "http://github.com/rxt1077/MeshMon"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring "1.9.6"]
                 [ring/ring-defaults "0.3.4"]
                 [com.github.seancorfield/next.jdbc "1.3.847"]
                 [org.xerial/sqlite-jdbc "3.40.0.0"]
                 [org.clojure/data.json "2.4.0"]
                 [camel-snake-kebab "0.4.3"]]
  :main meshmon-backend.core
  :aot [meshmon-backend.core])
;;  :plugins [[lein-ring "0.12.5"]]
;;  :ring {:handler meshmon-backend.handler/app}
;;  :profiles
;;  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
;;                        [ring/ring-mock "0.3.2"]]}})
