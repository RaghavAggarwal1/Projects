all: encode.o decode.o
encode.o: encrytion.cpp
	g++ -std=c++11 -o encode encrytion.cpp

decode.o: decrytion.cpp
	g++ -std=c++11 -o decode decrytion.cpp

encode: encrytion.cpp
	g++ -std=c++11 -o encode encrytion.cpp

decode: decrytion.cpp
	g++ -std=c++11 -o decode decrytion.cpp