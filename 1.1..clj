(defn compare_last_symbol [string symbol]
  (= (str (nth string (- (count string) 1))) symbol)
)

(defn generate_string_rec [string n symbols sym_idx]
  (if (<= n (count string))
  
      (println string)
      
      (
        if (< sym_idx (count symbols))
           (
              if (or (= (count string) 0) (not (compare_last_symbol string (nth symbols sym_idx))))
                 (
                    do 
                      (generate_string_rec (str string (nth symbols sym_idx)) n symbols 0)
                      (generate_string_rec string n symbols (+ sym_idx 1))
                 )
                 (generate_string_rec string n symbols (+ sym_idx 1))
           )
           ()
      )
  )
)

(defn generate_string [n symbols]
  (generate_string_rec "" n symbols 0)
)

(generate_string 4 `("a" "b" "c"))