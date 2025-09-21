#include "maze.h"
#include <ncurses/ncurses.h>
#include <vector>
#include <stdexcept>
#include <iostream>
#include <cstdlib>

int randInt() {

	return 4; // random!!
}

	enum Bearing {
		NORTH = 1,
		SOUTH = 2,
		EAST = 4,
		WEST = 8
	};

void makeMaze(std::vector<int>& maze, int mRows, int mCols) {
	const int mSIZE = maze.size();
	std::vector<int> stack { rand() % mSIZE };
	int visitedCells = 1;

	while (visitedCells < mSIZE) {
		const int currentCell = stack.back();

		std::vector<int> neighbors;
		/*	
		auto offset = [=](int x, int y) {
			return ((currentCell / mRows) + y) * mRows +  ((currentCell % mCols) + x);
		};*/

		// calculate index of neighbor cells as if on an xy coordinate plane
		const int north = ((currentCell / mCols) - 1) * mCols + ((currentCell % mCols) + 0);
		const int south = ((currentCell / mCols) + 1) * mCols + ((currentCell % mCols) + 0);
		const int east  = ((currentCell / mCols) + 0) * mCols + ((currentCell % mCols) + 1);
		const int west  = ((currentCell / mCols) + 0) * mCols + ((currentCell % mCols) - 1);
	
		// a cell is "visited" if it is non-zero
		try {
		if ((currentCell / mCols) > 0 && !maze.at(north))				neighbors.push_back(north);
		if ((currentCell / mCols) < mRows - 1 && !maze.at(south))		neighbors.push_back(south);
		if ((currentCell % mCols) < mCols - 1 && !maze.at(east))		neighbors.push_back(east);
		if ((currentCell % mCols) > 0 && !maze.at(west))				neighbors.push_back(west);
		} catch (std::out_of_range &e) {
			endwin();
			std::cerr << "out of range: max size is " << maze.size() << ", currentCell is " << currentCell << '\n'
				<< "\tnorth: " << north << '\n'
				<< "\tsouth: " << south << '\n'
				<< "\teast: " << east << '\n'
				<< "\twest: " << west << '\n';
			std::abort();
		}

		if (neighbors.size() > 0) {
			const int randCell = neighbors.at(rand() % neighbors.size());

			if (randCell == north) {
				maze[currentCell] |= NORTH;
				maze[randCell] |= SOUTH;
			}
			else if (randCell == south) {
				maze[currentCell] |= SOUTH;
				maze[randCell] |= NORTH;
			}
			else if (randCell == east) {
				maze[currentCell] |= EAST;
				maze[randCell] |= WEST;
			}
			else {
				maze[currentCell] |= WEST;
				maze[randCell] |= EAST;
			}

			stack.push_back(randCell);
			visitedCells++;
		}
		else {
			stack.pop_back();
		}
	}
}

void wprintMaze(WINDOW* win, const std::vector<int> cells, const int mRow, const int mCol, const int blCh) {
	const int mSIZE = mRow * mCol;
	int rIndex = 0;
	
	for (int i = 0; i < mSIZE; i += mCol) {
		int row = (rIndex*2 + 1); 

		for (int j = i; j < i+mCol; j++) {
			int col = ( (j % mCol)*2 + 1);
			if (!(cells[j] & EAST)) mvwaddch(win, row,col+1, blCh);

			if (!(cells[j] & SOUTH))  mvwaddch(win, row+1, col, blCh);
			// add bottom-right/top-left block
			mvwaddch(win, row+1, col+1, blCh);
		}
		rIndex++;
	}
}
