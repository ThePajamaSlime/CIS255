
mazeGame: main.o maze.o
	g++ *.o -o mazeGame -g -L/opt/ncurses/lib -lncurses

main.o: main.cpp maze.h
	g++ -c main.cpp -o main.o -I/opt/ncurses/include -std=c++14

maze.o: maze.cpp maze.h
	g++ -c maze.cpp -o maze.o -I/opt/ncurses/include -std=c++14

