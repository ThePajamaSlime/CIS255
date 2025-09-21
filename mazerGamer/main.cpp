#include "maze.h"
#include <ncurses/ncurses.h>
#include <unistd.h>
#include <sstream>
#include <iostream>
#include <fstream>
#include <vector>

void initNCurses() {
	initscr();
	start_color();
	cbreak();
	noecho();
}

int main(int argc, char* argv[]) {
	int mRows = 5;
	int mCols = 5;
	char color = 'c';

	std::ofstream log { "log" };

	int opt;
	while ((opt = getopt(argc, argv, "r:c:C:")) != -1) {
		std::istringstream optin{ };
		switch (opt) {
			case 'r':
				optin = std::istringstream(optarg);
				if (!(optin >> mRows)) {
					std::cerr << "Rows requires positive integer\n";
					return 1;
				}
				break;
			case 'c':
				optin = std::istringstream(optarg);
				if (!(optin >> mCols)) {
					std::cerr << "Columns requires positive integer\n";
					return 1;
				}
				break;
			case 'C':
				optin = std::istringstream(optarg);
				optin >> color; 
				break;
			default:
				return 1;
		}
	}

	const int mSIZE = mRows * mCols;
	constexpr int CELLSIZE = 3;

	const int mHeight = (mRows * CELLSIZE) - (mRows - 1);
	const int mWidth  = (mCols * CELLSIZE) - (mCols - 1);

	initNCurses();
	log << "Ncurses initialized!\n";
	if (has_colors())
		log << "Note: This terminal supports colors!\n";
	else
		log << "Note: This terminal DOESN'T support colors!\n";

	WINDOW* gameScr = newpad(mHeight, mWidth);
	keypad(gameScr, TRUE);
	refresh();

	short COLOR_FOREGROUND = COLOR_BLACK;
	short COLOR_BACKGROUND = COLOR_CYAN;

	switch (color) {
		case 'b':
			COLOR_BACKGROUND = COLOR_BLUE;
			break;
		case 'g':
			COLOR_BACKGROUND = COLOR_GREEN;
			break;
		case 'm':
			COLOR_BACKGROUND = COLOR_MAGENTA;
			break;
		case 'r':
			COLOR_BACKGROUND = COLOR_RED;
			break;
		case 'w':
			COLOR_BACKGROUND = COLOR_WHITE;
			break;
		case 'y':
			COLOR_BACKGROUND = COLOR_YELLOW;
			break;
	}		

	init_pair(1, COLOR_FOREGROUND, COLOR_BACKGROUND);

	constexpr chtype blCh = ' ' | COLOR_PAIR(1); // BLock CHaracter
	wborder(gameScr, blCh, blCh, blCh, blCh, blCh, blCh, blCh, blCh);

	std::vector<int> maze (mSIZE);

	makeMaze(maze, mRows, mCols);
	
	wprintMaze(gameScr, maze, mRows, mCols, blCh);
	wmove(gameScr, 1, 1);
	prefresh(gameScr, 0, 0, 5, 10, 5+mHeight, 10+mWidth);

	int ch;
	while ((ch = wgetch(gameScr)) != 10) {
		int y, x;
		getyx(gameScr, y, x);

		switch (ch) {
			case KEY_UP:
				if (mvwinch(gameScr, y-1, x) == blCh)
					wmove(gameScr, y, x);
				break;
			case KEY_DOWN:
				if (mvwinch(gameScr, y+1, x) == blCh)
					wmove(gameScr, y, x);
				break;
			case KEY_LEFT: 
				if (mvwinch(gameScr, y, x-1) == blCh)
					wmove(gameScr, y, x);
				break;
			case KEY_RIGHT:
				if (mvwinch(gameScr, y, x+1) == blCh)
					wmove(gameScr, y, x);
				break;
			case KEY_RESIZE:
				prefresh(gameScr, 0, 0, 5, 10, 5+mHeight, 10+mWidth);
				break;
		}
		//wrefresh(gameScr);
	}

	delwin(gameScr);
	endwin(); // END ncurses


	return 0;
}
