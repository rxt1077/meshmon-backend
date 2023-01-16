(ns meshmon-backend.db-test
  (:require [clojure.test :refer [deftest testing is]]
            [meshmon-backend.pb :as pb]
            [meshmon-backend.db :refer [get-all save-mesh-packet! start]])
  (:import [com.google.protobuf ByteString]))


(defn make-test-packet
  "Builds a valid, empty position MeshPacket proto-map"
  []
  (let [rx-time (quot (System/currentTimeMillis) 1000)
        pos (pb/clj-map->position {})
        pos-bytes (pb/proto-map->bytes pos)
        pos-bs (ByteString/copyFrom pos-bytes)
        data (pb/clj-map->data {:portnum :POSITION_APP :payload pos-bs})]
    (pb/clj-map->mesh-packet {:rx-time rx-time :decoded data})))

(defn bs->hash
  "Recursively replaces ByteStrings in a map with their hashCode"
  [map-with-bs]
  (reduce-kv
    (fn [m k v]
      (if (map? v)
        (assoc m k (bs->hash v))
        (if (instance? ByteString v)
          (assoc m k (.hashCode v))
          (assoc m k v))))
    {}
    map-with-bs))

;; a temporary sqlite file
(def jdbc-url
  (str "jdbc:sqlite:"
       (.getAbsolutePath (java.io.File/createTempFile "meshmon_test" ".db"))))

(deftest db-read-write
  (testing "Should be able to read/write MeshPackets to DB"
    (let [ds (start jdbc-url)
          save-packet (make-test-packet)
          _ (save-mesh-packet! ds save-packet)
          response-packet (:packet (first (get-all ds)))
          ;; convert ByteStrings to hashes for ease of comparison
          save-packet (bs->hash save-packet)
          response-packet (bs->hash response-packet)]
      (is (= response-packet save-packet)))))
