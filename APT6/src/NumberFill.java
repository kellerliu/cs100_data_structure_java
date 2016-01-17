import java.lang.Character;
import java.lang.Integer;
import java.util.*;

public class NumberFill {
	char[][] myGrid;
	int myCol, myRow;
	int count = 0;
	int max, maxCol;
	boolean colorFound;
	LinkedList<Integer> points;

	public boolean InRange(int row, int col) {
		return row >= 0 && row < myRow && col >= 0 && col < myCol;
	}

	public void explore(int row, int col) {
		if (!InRange(row, col))
			return;

		if (myGrid[row][col] == 'X')
			return;

		if (myGrid[row][col] == '.') {
			myGrid[row][col] = 'X';
			points.add(col);
			explore(row, col + 1);
			explore(row, col - 1);
			explore(row + 1, col);
			explore(row - 1, col);
		}

		else if (Character.isDigit(myGrid[row][col])) {
			colorFound = true;
			int tmp = Integer.valueOf(String.valueOf(myGrid[row][col]));

			if (tmp > max) {
				max = tmp;
				maxCol = col;
			} else if (tmp == max && col < maxCol) {
				maxCol = col;
			}
			myGrid[row][col] = 'X';
			points.add(col);
			explore(row, col + 1);
			explore(row, col - 1);
			explore(row + 1, col);
			explore(row - 1, col);
		}
	}

	public int gradient(String[] picture) {

		myRow = picture.length;
		myCol = picture[0].length();
		myGrid = new char[myRow][myCol];
		for (int i = 0; i < myRow; i++) {
			for (int j = 0; j < myCol; j++) {
				myGrid[i][j] = picture[i].charAt(j);
			}
		}

		for (int i = 0; i < myRow; i++) {
			for (int j = 0; j < myCol; j++) {
				points = new LinkedList<Integer>();

				colorFound = false;
				maxCol = myCol + 1;
				max = 0;
				explore(i, j);

				if (colorFound) {
					while (!points.isEmpty()) {
						count = count + max + points.remove() - maxCol;
					}
				}
			}
		}
		return count;
	}
}
