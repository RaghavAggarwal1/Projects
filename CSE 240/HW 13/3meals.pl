/* Facts */
entre(lunch,sandwhich).
entre(dinner,spaghetti).

side(lunch,chips).
side(lunch,lemonade).
side(dinner,bread).
side(dinner,greentea).

ingredient(chips,potato).
ingredient(chips,salt).
ingredient(lemonade,lemon).
ingredient(lemonade,sugar).

ingredient(bread,egg).
ingredient(bread,flour).
ingredient(greentea,green).
ingredient(greentea,tea).

/* Rule */
meal(X,Y) :-
    entre(X,_),side(X,_).
    
shoppinglist(X, Y) :-
    meal(X,Z), ingredient(Z,Y).