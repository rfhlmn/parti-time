(ns parti-time.core)

(defn time-window [time-frame next-time-frame]
  (let [{start-time :start-time} time-frame
        {end-time :start-time} next-time-frame]
    (if (java-time/before? end-time start-time)
      (throw (java.lang.IllegalArgumentException. "End time predates start time. Times must be strictly ordered."))
      (assoc time-frame
             :end-time end-time
             :duration-minutes (java-time/time-between start-time end-time :minutes)))))

(defn time-windows [time-line]
  (mapv time-window
        time-line
        (drop 1 time-line)))