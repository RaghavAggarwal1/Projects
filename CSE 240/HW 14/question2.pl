/*
Raghav Aggarwal
ASU ID: 1215935292
*/
/*2.1 Define a rule pizza(P, M, B, O, C) to find out how many of each topping can be contained
on a pizza, where P, M, B, O, and C are the numbers of the pepperoni, meatball, basil, olives,
and chicken toppings, respectively.*/

pizza(P, M, B, O, C) :-
    /* creating a list of possible outcomes for P M B O C */
    member(P, [0,1,2,3,4,5,6,7,8,9]),
    member(M, [0,1,2,3,4,5]),
    member(B, [0,1,2,3,4,5,6]),
    member(O, [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]),
    member(C, [0,1,2,3,4,5]),

    /* creating a formula for total weight */
    weight is P*5 + M*10 + B*7 + O*3 + C*8, 
    /*checking if weight is 45*/
    weight is 45.

/* 2.2 Write a rule called q2 :- condition, to ask the following question (goal), so that the grader to
type | ?- q2. To test the question. 
| ?- pizza(1, 2, 2, 2, 2). Put all answers of the question in a comment in the file.*/

q2 :-
    pizza(1, 2, 2, 2, 2).
%answer = NO

/* 2.3 */
q3 :-
    pizza(1, M, 1, O, C).
%ans : No

/* 2.4 */
q4 :-
    pizza(P, M, B, O, 1).
/* Answer
P=6 M=0 B=1;
P=4 M=1 B=1;
P=2 M=2 B=1;
P=0 M=2 B=1;
*/