(ns turbine-data-loader.core
  (:gen-class)
  (require [clojure.java.io :as io]
           [clj-http.client :as client]
           [cheshire.core :as json]))

(def resource-conf (-> "config.json" io/resource))

(defn read-conf [file]
  (json/parse-string (slurp (or file resource-conf)) true))

(defn post-event [turbine-url event-json]
  (client/post turbine-url {:body event-json}))

(defn make-turbine-url [{:keys [turbine-base database collection]}]
  (str turbine-base "/db/" database "/" collection))

(defn load-data-from-file [conf in-file]
  (let [turbine-url (make-turbine-url conf)]
    (with-open [rdr (io/reader (io/file in-file))]
      (doseq [event-json (line-seq rdr)]
        (post-event turbine-url event-json)))))

(defn load-data-from-stdin [conf]
  (let [turbine-url (make-turbine-url conf)]
    (doseq [event-json (line-seq (java.io.BufferedReader. *in*))]
      (post-event turbine-url event-json))))

(defn print-help-output []
  (println
    "USAGE:\n"
    "    STDIN: java -jar data-loader.jar <conf.json>\n"
    "    FILE:  java -jar data-loader.jar <conf.json> <input-file>\n"))

(defn -main [& [conf-file in-file & args]]
  (if-not conf-file
    (print-help-output)
    (let [conf (read-conf conf-file)]
      (if in-file
        (load-data-from-file conf in-file)
        (load-data-from-stdin conf)))))