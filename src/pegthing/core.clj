(ns pegthing.core
  (:gen-class))

(defn tri*
  ([] (tri* 0 1))
  ([sum n]
   (let [newsum (+ sum n)]
     (cons newsum (lazy-seq (tri* newsum (inc n)))))))

(def tri (tri*))

(defn triangular?
  [n]
  (= n (last (take-while #(>= n %) tri))))

(defn row-tri
  [n]
  (last (take n tri)))

(defn row-num
  [pos]
  (inc (count (take-while #(> pos %) tri))))

(defn in-bounds?
  [max-pos & positions]
  (every? #(>= max-pos %) positions))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
