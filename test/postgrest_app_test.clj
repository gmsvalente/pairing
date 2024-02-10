(ns postgrest-app-test
  (:require
    [clj-http.client :as http]
    [clojure.test :refer [deftest is use-fixtures]]
    [postgrest-app.core]
    [postgrest-app-fixture :refer [std-system-fixture]]))

(def config {})

(use-fixtures :once (partial std-system-fixture config))

(deftest index-test
  (is (= {:body   "Index page"
          :status 200}
         (-> {:url                  "http://localhost:3333/"
              :unexceptional-status (constantly true)
              :method               :get}
             http/request
             (select-keys [:status :body])))))
