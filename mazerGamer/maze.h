#ifndef MAZE_H
#define MAZE_H
#include <vector>
#include <ncurses/ncurses.h>

void makeMaze(std::vector<int>& maze, int mRows, int mCols);

void wprintMaze(WINDOW* win, const std::vector<int>, const int y, const int x, const int ch );

#endif
