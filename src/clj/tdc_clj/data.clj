(ns tdc-clj.data)

(defonce key-counter (atom 0))

(defn generate-key []
  (let [key (swap! key-counter inc)]
    (keyword (str "key-" key))))

(def matches
  [{:id 1 :home "Rosenborg" :away "Molde" :league 1}
   {:id 2 :home "Bod�/Glimt" :away "Troms�" :league 1}
   {:id 3 :home "Chelsea" :away "Manchester United" :league 2}
   {:id 4 :home "Borussia Dortmund" :away "Bayern Munchen" :league 3}])

(def types
  [:default :yellow :red :penalty :goal :injury :drama :chance :sub])

(defn match-data []
  [{:id (generate-key) :league 1 :match 1 :type :chance :message "S�derlund g�r i duell med Berg Hestad h�yt i banen, og f�r frispark!"}
   {:id (generate-key) :league 1 :match 2 :type :yellow :message "Trond Olsen blir tatt uten � f� frispark. Blir s� sint at han f�r gult kort av dommeren"}
   {:id (generate-key) :league 3 :match 4 :type :sub :message "Marco Reus f�r stoppet Arjen Robben i siste liten, like f�r han var alene med keeper der"}])

(defn get-random-data []
  (rand-nth (match-data)))