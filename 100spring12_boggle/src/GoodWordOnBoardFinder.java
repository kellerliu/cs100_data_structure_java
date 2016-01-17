import java.util.ArrayList;
import java.util.List;

public class GoodWordOnBoardFinder implements IWordOnBoardFinder {

	public List<BoardCell> cellsForWord(BoggleBoard board, String word) {

		List<BoardCell> list = new ArrayList<BoardCell>();
		for (int r = 0; r < board.size(); r++) {
			for (int c = 0; c < board.size(); c++) {
				if (PathExist(board, r, c, list, word, 0)) {
					return list;
				}
			}
		}
		return list;
	}

	private boolean PathExist(BoggleBoard board, int row, int col,
			List<BoardCell> list, String word, int Index) {

		if (Index == word.length())
			return true;

		if (isOffBoard(board, row, col))
			return false;

		BoardCell addBoard = new BoardCell(row, col);

		if (list.contains(addBoard))
			return false;

		String current = word.charAt(Index) + "";

		String letterOnCell = board.getFace(row, col);

		if (current.equals("q")) {
			if (Index == word.length() - 1)
				return false;
			if (word.charAt(Index + 1) != 'u')
				return false;
			if (!letterOnCell.equals("qu"))
				return false;
			Index++;

		}
		else if (!letterOnCell.equals(current))
			return false;

		list.add(addBoard);

		// for (int r = 0; r < board.size(); r++) {
		// for (int c = 0; c < board.size(); c++) {
		// BoardCell neighCell = new BoardCell(r, c);
		// if (neighCell.isNeighbor(addBoard))
		// {
		// if( PathExist(board, r, c, list, word, Index + 1))
		// return true;
		//
		// }
		// }
		// }

		int[] rdelta = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] cdelta = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int k = 0; k < rdelta.length; k++) {
			if (PathExist(board, row + rdelta[k], col + cdelta[k], list, word,
					Index + 1))
				return true;
		}

		list.remove(addBoard);
		return false;
	}

	private boolean isOffBoard(BoggleBoard board, int row, int col) {
		return row < 0 || row >= board.size() || col < 0 || col >= board.size();
	}

}
