public class FloodRelief {
	
	private char[][] myGrid;
	private int myRow, myCol, unpumpfield, minRow, minCol;
	private char min;

	public int minimumPumps(String[] heights) {
		myRow = heights.length;
		myCol = heights[0].length();
		myGrid = new char[myRow][myCol];
		int pump = 0;
		for (int r = 0; r < myRow; r++) {
			for (int c = 0; c < myCol; c++) {
				myGrid[r][c] = heights[r].charAt(c);
			}
		}
		while (detectLow()) {
			doPump(min, minRow, minCol);
			pump++;
		}
		return pump;
	}

	public void doPump(char low, int row, int col) {
		if (!inRange(row, col))
			return;
		char current = myGrid[row][col];
		if (current >= low) {
			myGrid[row][col] = '*';// set relief field as '*', also 42, <a.
			doPump(current, row + 1, col);
			doPump(current, row - 1, col);
			doPump(current, row, col + 1);
			doPump(current, row, col - 1);
		}

	}

	public boolean detectLow() {
		unpumpfield = myRow * myCol;
		min = '{';//  '{' 123, >z, ensure will check every field; 
		for (int r = 0; r < myRow; r++) {
			for (int c = 0; c < myCol; c++) {
				char current=myGrid[r][c];
				if (current == '*')
					unpumpfield--;
				else if (current < min) {
					min = current;
					minRow = r;
					minCol = c;
				}
			}
		}
		if (unpumpfield == 0)
			return false;
		return true;
	}

	private boolean inRange(int row, int col) {
		return 0 <= row && row < myGrid.length && 0 <= col
				&& col < myGrid[0].length;
	}


}