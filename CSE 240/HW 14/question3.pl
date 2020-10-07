/*
Raghav Aggarwal
ASU ID: 1215935292
*/
qsort([],[]) :- !. 	% empty list is already sorted
qsort([x|[Pivot|Tail]],Sorted):-	% Take second number as pivot
	split(Pivot, Tail, L1, L2), 
	qsort(L1,Sorted1), 	% sort first part
	qsort(L2,Sorted2),	% sort second part
	append(Sorted1,[x|[Pivot|Sorted2]], Sorted).

%stopping condition
split(_,[],[],[]).		% stopping condition
%size n 
split(Pivot,[X|T],[X|Le],Gt):-		% take first from Tail 
	X=<Pivot, split(Pivot,T,Le,Gt).	% and put it into Le
%size n
split(Pivot,[X|T],Le,[X|Gt]):-		% take first from Tail
	X > Pivot, split(Pivot,T,Le,Gt).	% and put it into Gt

%size of m  = n-1
