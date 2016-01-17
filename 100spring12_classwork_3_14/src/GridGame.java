public class GridGame {

	// the apt for gridgame is here:
	// http://www.cs.duke.edu/csed/newapt/gridgame.html

	char[][] grid;

	public boolean canPlaceAt(int row, int col) {
		if (grid[row][col] == 'X')
			return false;
		if (row > 0)
			if (grid[row - 1][col] == 'X')
				return false;
		if (col > 0)
			if (grid[row][col - 1] == 'X')
				return false;
		if (row < grid.length - 1)
			if (grid[row + 1][col] == 'X')
				return false;
		if (col < grid[0].length - 1)
			if (grid[row][col + 1] == 'X')
				return false;
		return true;
	}

	public int winningMoves(String[] gridInput) {

		// this just converts our array of strings
		// to a 2D char array for easy access/modification
		grid = new char[gridInput.length][];
		for (int r = 0; r < grid.length; r++) {
			grid[r] = gridInput[r].toCharArray();
		}
		return winningMovesRecursive();

	}

	public int winningMovesRecursive() {
		// your code goes here
		// HINTS BELOW
		// don't forget to use the very handy "canPlaceAt" above
		int ret = 0;
		for (int r = 0; r < grid.length; r++)
			for (int c = 0; c < grid[0].length; c++) {
				if (canPlaceAt(r, c)) {
					grid[r][c] = 'X';
					if (winningMovesRecursive() == 0)
						ret++;
					grid[r][c] = '.';
				}
			}
		return ret;
	}
}

/*
 * 
 * 
 * HINT 1: A move is a winning move, if after that move the opponent has 0 ways
 * to win (recursion)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * HINT 2 Check every possible move to see if it is a winning move Count how
 * many are Return that number
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * HINT 3 For each row and each column if I can place an X in this position
 * place an X at that position call myself recursively if it's a winning move,
 * increment my count remove the X I placed (backtracking!)
 * 
 * return my count
 */