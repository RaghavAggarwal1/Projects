;Your Name: Raghav Aggarwal
;Course: CSE 240


;Q1 (3 points)
; enter your code here:
(define OR-GATE(lambda (a b)
          (if(= a 1)
          1
                  (if(= b 1)
                     ; 1 for all casses except both are 0
                  1
                  ; 0 if and b both are 0
                  (if(= b 0)
                     0
                     
                  0)))
               ))
(define AND-GATE(lambda (a b)
          (if(= a 0)
          0
          ; 1 for all casses except both are 1
                  (if(= b 1)
                  1
                  ; 0 for all other cases 0
                  (if(= b 0)
                  0
                     
                  1)))                
                  
                  ))

(define NOT-GATE(lambda (a)
                  ;if 1 then 0
                  (if (= a 1)
                      0
                      ;if 0 then 1
                  1))
  )

; Test cases
(newline)
(Display "AND-Gate Output\n")
(AND-GATE 0 0)
(AND-GATE 0 1)
(AND-GATE 1 0)
(AND-GATE 1 1)
; Expected outputs
;0
;0
;0
;1
; Test cases
(newline)
(Display "OR-Gate Output\n")
(OR-GATE 0 0)
(OR-GATE 0 1)
(OR-GATE 1 0)
(OR-GATE 1 1)
; Expected outputs
;0
;1
;1
;1
; Test cases
(newline)
(Display "NOT-Gate Output\n")
(NOT-GATE 0)
(NOT-GATE 1)
; Expected outputs
;1
;0

; Q2 (2 points)
; enter your code here:
(define XOR-GATE (lambda (a b)
                   ; based on the combination of and or and not gate 
                   (OR-GATE(AND-GATE(NOT-GATE a) b) (AND-GATE a (NOT-GATE b)) )
  ))

; Test cases
(newline)
(newline)
(Display "XOR-Gate Output\n")
(XOR-GATE 0 0)
(XOR-GATE 0 1)
(XOR-GATE 1 0)
(XOR-GATE 1 1)
; Expected outputs
;0
;1
;1
;0

;Q3.1 (5 points)
; enter your code here:
(define halfAdder (lambda (x a b)
                    ; based on the diagram 
                    (XOR-GATE x (XOR-GATE a b))
                   ))

;Q3.2 (5 points)
; enter your code here:
(define carry-out (lambda (x a b)
                    ;based on the diagram 
                    (OR-GATE(AND-GATE x (XOR-GATE a b)) (AND-GATE a b))
                      ))

;Q3.3 (5 points)
; enter your code here:
(define fullAdder (lambda (x a b)
                    ; calling the other defined function
                    ;based on the diagram
                    (cons (carry-out x a b) (halfAdder x a b) )
                   
                          ))
; Test cases
(newline)
(Display "halfAdder Output\n")
(halfAdder 0 0 0) 	
(halfAdder 0 0 1) 	
(halfAdder 0 1 0) 	
(halfAdder 0 1 1)	
(halfAdder 1 0 0) 	
(halfAdder 1 0 1)	
(halfAdder 1 1 0) 	
(halfAdder 1 1 1)

; Expected outputs
;(0 . 0)
;(0 . 1)
;(0 . 1)
;(1 . 1)
;(0 . 1)
;(1 . 1)
;(1 . 1)
;(1 . 1)

; Test cases
(newline)
(Display "fullAdder Output\n")
(fullAdder 0 0 0) 	
(fullAdder 0 0 1) 	
(fullAdder 0 1 0) 	
(fullAdder 0 1 1)	
(fullAdder 1 0 0) 	
(fullAdder 1 0 1)	
(fullAdder 1 1 0) 	
(fullAdder 1 1 1)

;Q4.1 (4 points)
; enter your code here:
(define tail (lambda (lst)
               
  (if (null? (cdr lst))
      ;this is the last element 
  (car lst)
  ;else keep on running till last element
  (tail (cdr lst))
  )
  ))

;Q4.2 (4 points)
(define rmtail (lambda (lst)
                 ;running till the list ends
  (if (null? (cdr lst))
      ;making a new list
  '()
  ;saving all elements except for the last one
  (cons (car lst)(rmtail (cdr lst)) )
  )
  ))

;Q4.3
; Step 1 size-n problem: Lines of code
; ----> the size n of the problem would be enetered by the user. and it would be incremented from 0 to n 
;(lambda (A B n)

; Step 2 Stopping condition: Lines of code
; ----> stopping condition would be when the loop reaches the value of n which by default would be 32

; Step 3 size-m problem: Lines of code
; ----> the size m of the problem is n-1. 

; Step 4: Lines of code
; ----> (if (null? A)



;Q4.4 (18 points)
; enter your code here:
(define n-bit-adder (lambda (A B n)
                      ; displaying the result of the addition
                         (cons '(0) (recursiveAdd A B 0))
                      )
 )




(define recursiveAdd (lambda (A B c)
                       ;running the list till the list ends
                       (if (null? A)
                           ;making a new list
                       '()
                       (let ((t (+ (tail A) (tail B) c)))
                         ;adding all the nos and adding the nos to the new list
                        (append (recursiveAdd (rmtail A)(rmtail B)(car (fullAdder (tail A) (tail B) c)) )
                                 (list (cdr (fullAdder (tail A) (tail B) c)) )
                                 ) 
                           )
                       )
                         ))



;Test cases
(define X1 '(0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0) )	
(define X2 '(1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1) )	
(define X3 '(0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1) )	
(define X4 '(1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0) )
(define X5 '(1 1 0 1 0 1 0 1 0 1 0 1 0 1 1 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 1 1) )	
(define X6 '(1 1 1 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 1 0) )


(newline)
(Display " n-bit-adder Output\n")
( n-bit-adder  X1 X2 32)
( n-bit-adder  X3 X4 32)
( n-bit-adder  X5 X6 32)
( n-bit-adder  X2 X3 32)
( n-bit-adder  X4 X5 32)
( n-bit-adder  X1 X6 32)
; Expected outputs
;(0 (1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0))
;(0 (1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0))
;(1 (1 1 0 1 0 0 1 1 0 1 0 0 1 1 1 0 0 1 0 1 1 0 0 1 0 1 1 0 0 1 1 0))
;(0 (1 1 0 1 1 1 0 1 1 1 0 1 1 1 0 1 1 1 0 1 1 1 0 1 1 1 0 1 1 1 0 1))
;(1 (1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 1 0))
;(0 (1 0 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0 0 0 0))
