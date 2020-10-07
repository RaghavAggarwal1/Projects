/*
Raghav Aggarwal
ASU ID: 1215935292
*/

/* question 1.1 

Consider to use the minimum number of color to color the following western states of the United States, and make sure that the neighboring states not colored in the same color. [15 points]

Alaska => yellow
Arizona, => orange 
California, => yellow
Colorado, => red
Hawaii, => red
Idaho, => yellow
Montana, => red
Nevada, => red
New Mexico, => yellow
Oregon, => orange
Utah, => green
Washington, => red
Wyoming, => orange

1.1) How many colors you have used? 
4 colors 

1.2 Use Prolog facts to represent the neighboring relationship and the color of the states. Note, Alaska and Hawaii have no neighboring states, and two states are neighboring if they share an edge of border, not a point of border.
*/

/* facts for neighbors */

neighborof(Washington,Oregon).
neighborof(Washington,Idaho).

neighborof(Oregon,Washington).
neighborof(Oregon,Idaho).
neighborof(Oregon,California).
neighborof(Oregon,Nevada).

neighborof(California,Oregon).
neighborof(California,Nevada).
neighborof(California,Arizona).

neighborof(Idaho,Washington).
neighborof(Idaho,Oregon).
neighborof(Idaho,Nevada).
neighborof(Idaho,Utah).
neighborof(Idaho,Wyoming).
neighborof(Idaho,Montana).

neighborof(Nevada,Idaho).
neighborof(Nevada,Oregon).
neighborof(Nevada,California).
neighborof(Nevada,Arizona).
neighborof(Nevada,Utah).

neighborof(Arizona,California).
neighborof(Arizona,Nevada).
neighborof(Arizona,Utah).
neighborof(Arizona,NewMexico).

neighborof(Utah,Arizona).
neighborof(Utah,Colorado).
neighborof(Utah,Wyoming).
neighborof(Utah,Idaho).
neighborof(Utah,Nevada).

neighborof(Montana,Idaho).
neighborof(Montana,Wyoming).

neighborof(Wyoming,Montana).
neighborof(Wyoming,Idaho).
neighborof(Wyoming,Utah).
neighborof(Wyoming,Colorado).

neighborof(Colorado,Wyoming).
neighborof(Colorado,Utah).
neighborof(Colorado,NewMexico).

neighborof(NewMexico,Colorado).
neighborof(NewMexico,Utah).
neighborof(NewMexico,Arizona).

/* facts for colors */
colorof(red,Washington).
colorof(orange,Oregon).
colorof(yellow,California).
colorof(yellow,Idaho).
colorof(red,Nevada).
colorof(green,Utah).
colorof(orange,Arizona).
colorof(red,Montana).
colorof(orange,Wyoming).
colorof(red,Colorado).
colorof(yellow, NewMexico).

/* 1.3 Write the adjacent rule.*/

adjacent(X, Y) :- 
	neighborof(X, Y);  neighborof(Y, X).

/* 1.4 Write the miscolor rule to make sure that the neighboring states not colored in the same color.*/

miscolor(S1, S2, Color) :-
	adjacent(S1, S2),
	colorof(Color,S1),
	colorof(Color,S2).

/* 1.5 Write a rule called q :- condition. When testing, typing q will test your miscolor rule */

q :-
    miscolor(Arizona,Utah,orange).
/* Answer should be TRUE */
