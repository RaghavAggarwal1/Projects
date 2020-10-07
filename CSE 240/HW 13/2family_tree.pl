/* Database for family tree. It consists of facts and rules. */
/* The section in the highlighted box above has been completed for you */
/* Facts */
male(abe).
male(rob).
male(jim).
female(joy).
female(ana).
father_of(abe, ana). /* abe is the father of ana*/
father_of(abe, rob). /* abe is the father of ana*/
father_of(abe, jim). /* abe is the father of ana*/
mother_of(joy, rob). /* joy is the mother of rob*/
mother_of(joy, jim). /* joy is the mother of rob*/
mother_of(joy, ana). /* joy is the mother of rob*/

male(mac).
male(ben).
male(bud).
male(tex).
male(roy).
male(kai).
male(lee).

female(mia).
female(kim).
female(mae).
female(amy).
female(zoe).
female(val).
female(pam).

father_of(jim, kim).
father_of(jim, mac).
mother_of(mia, kim).
mother_of(mia, mac).

father_of(ben, bud).
father_of(ben, amy).

mother_of(mae, bud).
mother_of(mae, amy).

father_of(bud, zoe).
father_of(bud, val).
father_of(bud, tex).
father_of(bud, roy).

mother_of(ana, zoe).
mother_of(ana, val).
mother_of(ana, tex).
mother_of(ana, roy).

father_of(kai, lee).
father_of(kai, pam).

mother_of(amy, lee).
mother_of(amy, pam).

/* Complete the facts given in the diagram above */
/* Rules */
is_male(X) :-
    male(X);
    father_of(X, _).
/*2.2*/
is_female(X) :-
    female(X);
    mother_of(X, _).

/*2.3*/
grandmother_of(X,Z) :-
    mother_of(X,Y),
    (mother_of(Y,Z); father_of(Y,Z)).


grandfather_of(X,Z) :-
    father_of(X,Y),
    (mother_of(Y,Z); father_of(Y,Z)).

/*2.4*/
sibling_of(X,Y) :-
    (father_of(Z,X), father_of(Z,Y)).

/*2.5*/
parent_of(X,Y) :-
    (father_of(X,Y);mother_of(X,Y)).

/*2.6*/
descedent_of(X,Y) :-
    (father_of(Z,Y);mother_of(Z,Y)),
    (descedent_of(X,Z)).