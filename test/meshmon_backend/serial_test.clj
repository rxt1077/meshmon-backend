(ns meshmon-backend.serial-test
  (:require [clojure.test :refer [deftest is testing]]
            [meshmon-backend.serial :refer [fsm! start-1 start-2]]))

(deftest fsm-pull-test
  (testing "FSM should pull the proto bytes out of a correct stream"
    (let [size-1 (byte 0x00)
          size-2 (byte 0x03)
          data-1 (byte 0x01)
          data-2 (byte 0x02)
          data-3 (byte 0x03)
          stream [start-1 start-2 size-1 size-2 data-1 data-2 data-3]
          ;; should return nils until the last data byte is read
          ;; then it returns the data
          result (map fsm! stream)
          nils (take 5 result)
          data (last result)]
      (and
        (is (= nils [nil nil nil nil nil]))
        (is (java.util.Arrays/equals data (byte-array [data-1 data-2 data-3])))))))

(deftest fsm-no-second-start-test
  (testing "FSM should print an error if it's waiting for start-2 and it
           receives something else"
    (let [_ (fsm! start-1)
          result-2 (with-out-str (fsm! (byte 0x00)))]
      (is (= result-2 "Expecting start-2, received 0x00 \n")))))
