(defproject meshmon-backend "1.0.0"
  :description "Backend for MeshMon that serves packets from a sqlite3 database"
  :url "http://github.com/rxt1077/MeshMon"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [compojure "1.7.0"]
                 [ring "1.9.6"]
                 [ring/ring-defaults "0.3.4"]
                 [ring-cors "0.1.13"]
                 [ring-logger "1.1.1"]
                 [com.github.seancorfield/next.jdbc "1.3.847"]
                 [org.xerial/sqlite-jdbc "3.40.0.0"]
                 [org.clojure/data.json "2.4.0"]
                 [clj-serial "2.0.5"]
                 [com.appsflyer/pronto "2.1.0"]
                 [com.google.protobuf/protobuf-java "3.21.9"]
                 [org.clojure/tools.cli "1.0.214"]
                 [com.taoensso/timbre "6.0.4"]
                 [camel-snake-kebab "0.4.3"]
                 [org.clojure/core.async "1.6.673"]]
  :main meshmon-backend.core
  :aot [meshmon-backend.core]
  :java-source-paths ["src/java"]
  :jar-name "meshmon-backend-%s.jar"
  :uberjar-name "meshmon-backend-%s-standalone.jar"
  :plugins [[com.appsflyer/lein-protodeps "1.0.5"] [com.github.clj-kondo/lein-clj-kondo "0.2.4"]]
  :lein-protodeps {:output-path "src/java"
                   :proto-version "3.21.12"
                   :repos {:meshtastic {:repo-type :git
                                        :config {:clone-url "git@github.com:meshtastic/protobufs.git"
                                                 :rev "master"}
                                        :proto-paths [""]
                                        :dependencies [""]}
                           :web {:repo-type :filesystem
                                 :config {:path "resources/protobufs"}
                                 :proto-paths [""]
                                 :dependencies [""]}}})
