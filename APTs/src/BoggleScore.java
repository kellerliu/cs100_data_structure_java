public class BoggleScore {

	public long bestScore(String[] grid, String[] words) {
		// fill in code here
		char[][] myboard = new char[grid.length][];
		for (int i = 0; i < grid.length; i++) {
			myboard[i] = grid[i].toCharArray();
		}

		long sum = 0;
		return 0;
	}

	public boolean canFormWord(String word, char[][] board, int row, int col) {
		if (row >= board.length || row < 0)
			return false;
		if (col >= board[0].length || col < 0)
			return false;

		if (word.charAt(0) != board[row][col])
			return false;
		else if (word.length() == 1)
			return true;

		return canFormWord(word.substring(1), board, row - 1, col - 1)
				|| canFormWord(word.substring(1), board, row - 1, col)
				|| canFormWord(word.substring(1), board, row - 1, col + 1)
				|| canFormWord(word.substring(1), board, row, col - 1)
				|| canFormWord(word.substring(1), board, row, col + 1)
				|| canFormWord(word.substring(1), board, row + 1, col - 1)
				|| canFormWord(word.substring(1), board, row + 1, col)
				|| canFormWord(word.substring(1), board, row + 1, col + 1);

	}

	public int wordRepeat(String word, char[][] board) {
		int repeat = 0;
		int index = 0;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != word.charAt(index))
					continue;
				index++;

			}
		}

		return repeat;
	}
}