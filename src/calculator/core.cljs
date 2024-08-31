(ns calculator.core
  (:require [reagent.core :as r]
            [reagent.dom :as d]))


;; -------------------------
;; Atoms (= states)


(def calculation (r/atom 0))

(def last-selected-number (r/atom ""))

(def last-selected-action (r/atom ""))

(def last-click (r/atom "number")) ;; "number" | "action"

(def calculation-in-progress (r/atom false))


;; -------------------------
;; Actions


(defn do-calculate [action number]
  (let [number-as-int (int number)]
    (if (false? @calculation-in-progress)
      (do
        (reset! calculation-in-progress true)
        (reset! calculation number-as-int))
      (do
        (case action
          "+" (reset! calculation (+ @calculation number-as-int))
          "*" (reset! calculation (* @calculation number-as-int))
          "-" (reset! calculation (- @calculation number-as-int)))
        (reset! last-selected-number @calculation)))))


(defn handle-number-click [number]
(println "Number clicked:" number)
  (if (= @last-click "number")
    (swap! last-selected-number str number)
    (reset! last-selected-number number))
  (reset! last-click "number"))


(defn handle-action-click [action]
  (println "Action clicked:" action)
  (reset! last-selected-action action)
  (if (= @last-click "number")
    (do-calculate action @last-selected-number)
    (reset! last-selected-action action))
  (reset! last-click "action"))


;; -------------------------
;; Views


(defn display []
  [:input {:class "result-view"
           :type :text
           :disabled true
           :placeholder "feed me numbers"
           :value @last-selected-number}])

(defn action-button [action]
  ^{:key action}
  [:button {:class "action-button"
            :on-click #(handle-action-click (str action))} action])

(defn number-button [number]
  ^{:key number}
  [:button {:class "number-button"
            :on-click #(handle-number-click (str number))}
   number])

(defn calculator []
  [:div {:class "grid"}
   (display)
   (map number-button (range 7 10))
   (action-button "+")
   (map number-button (range 4 7))
   (action-button "-")
   (map number-button (range 1 4))
   (action-button "*")
   (number-button 0)
   (action-button ",")
   (action-button "/")
   (action-button "=")])


(defn home-page []
  [:div
   [:div [:h2 "Clojure(Script) Calculator"]]
   [calculator]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
