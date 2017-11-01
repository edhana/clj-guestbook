(ns guestbook.routes.home
  (:require [guestbook.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [guestbook.db.core :as db]))

(defn home-page []
  (layout/render
    "home.html"
    {:messages (db/get-messages)}))

(defn about-page []
  (layout/render "about.html"))

(defn whitesheep-page []
  (layout/render "whitesheep.html"))

(defn save-message! [{:keys [params]}]
  (db/save-message!
    (assoc params :timestamp (java.util.Date.)))
    (response/found "/"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/whitesheep" [] (whitesheep-page)
  (POST "/message" request (save-message! request))))
