public class GridGame {


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

