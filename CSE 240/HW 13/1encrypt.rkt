(define k (read)) ;Global variable key 

;function for encryption using map
(define encrypt (lambda (s)
                     (list->string(map (char-encryption k)(string->list s))
                     ))
  )
;function to encrypt
(define char-encryption (lambda (k)(lambda (c)
                                     
                          (if (char-alphabetic? c);if alphabet then call rotation
                              (charachter-rotation c k)
                              (if
                              (char-numeric? c) ;;if numeric then call rotation
                              (charachter-rotation c k)
                              (if
                              (char-whitespace? c) ;if blankspace then call rotation
                              (charachter-rotation c k)
                              c
                              )))
                          )))

(define charachter-rotation (lambda (c k)
                              (integer->char(+(char->integer c)k));adding the key to the digit so that we can encyrpt

                              ))



;function for decryption using map
(define decrypt (lambda (s)
                     (list->string (map (char-decryption k)(string->list s))
                     ))
  )

;function to decrypt
(define char-decryption (lambda (k)(lambda (c)
                         (if (char-alphabetic? c) ;if alphabet then call derotation
                              (charachter-derotation c k)
                              (if
                              (char-numeric? c) ;if numeric then call derotation
                              (charachter-derotation c k)
                              (if
                              (char-whitespace? c) ;if blankspace then call derotation
                              (charachter-derotation c k)
                              (if (char=? c #\#) ;if blankspace then call derotation
                                  (charachter-derotation c k)
                              (if (char=? c #\{) ;if end char z then call derotation
                                  (charachter-derotation c k)
                              (if (char=? c #\|) ;if end char y then call derotation
                                  (charachter-derotation c k)
                              (if (char=? c #\}) ;if end char x then call derotation
                                  (charachter-derotation c k)
                              c
                              )))))))
                          )))

(define charachter-derotation (lambda (c k)
                              (integer->char(-(char->integer c)k)) ;subtracting the key to the digit so that we can encyrpt

                              ))