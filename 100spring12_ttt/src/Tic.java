//reference
import java.util.*;

public class Tic {
	private static char SPACE = ' ';

	ArrayList<String> myBoards;
	HashSet<String> winForO, winForX;

	public Tic() {
		myBoards = new ArrayList<String>();
		winForO = new HashSet<String>();
		winForX = new HashSet<String>();
	}

	public void printResults() {
		System.out.println("total # boards = " + myBoards.size()
				+ ", # wins for 'O' = " + winForO.size()
				+ ", # wins for 'X' = " + winForX.size());
		System.out.println();
		System.out.println("Unique boards:");
		Collections.sort(myBoards);
		for (String board : myBoards) {
			System.out.println(board);
		}
	}

	public void process(char[] board) {
		String newBoard = new String(board);
		if (!myBoards.contains(newBoard)) {
			myBoards.add(new String(board));
			//if (myBoards.size() % 100 == 0) {
				//System.out.println(myBoards.size());
		//	}
		}
	}

	public void eliminateSymmetricBoards() {

		ArrayList<String> updateBoards = new ArrayList<String>();
		HashSet<String> updateWinForO = new HashSet<String>();
		HashSet<String> updateWinForX = new HashSet<String>();

		for (int m = 0; m < myBoards.size(); m++) {
			String boardString = myBoards.get(m);
			ArrayList<String> symBoards = symmetricBoards(boardString);
			Collections.sort(symBoards);
			String firstBoard = symBoards.get(0);
			if (!updateBoards.contains(firstBoard)) {
				updateBoards.add(firstBoard);
			}

			if (winForX.contains(firstBoard)) {
				updateWinForX.add(firstBoard);
			}

			if (winForO.contains(firstBoard)) {
				updateWinForO.add(firstBoard);
			}
		
		}

		myBoards = updateBoards;
		winForO = updateWinForO;
		winForX = updateWinForX;
	}

	private ArrayList<String> symmetricBoards(String boardString) {
		char[] board = boardString.toCharArray();
		String symmetricBoardString;
		ArrayList<String> symmetricList = new ArrayList<String>();
		symmetricList.add(boardString);
		char[] symmetricBoard = new char[board.length];
		
		for (int i = 0; i < 4; i++) {

			symmetricBoard[0] = board[2];
			symmetricBoard[1] = board[1];
			symmetricBoard[2] = board[0];
			symmetricBoard[3] = board[5];
			symmetricBoard[4] = board[4];
			symmetricBoard[5] = board[3];
			symmetricBoard[6] = board[8];
			symmetricBoard[7] = board[7];
			symmetricBoard[8] = board[6];
			symmetricBoardString = new String(symmetricBoard);
			if (!symmetricList.contains(symmetricBoardString))
				symmetricList.add(symmetricBoardString);
			
			if (i != 3) {
				symmetricBoard[0] = board[6];
				symmetricBoard[1] = board[3];
				symmetricBoard[2] = board[0];
				symmetricBoard[3] = board[7];
				symmetricBoard[4] = board[4];
				symmetricBoard[5] = board[1];
				symmetricBoard[6] = board[8];
				symmetricBoard[7] = board[5];
				symmetricBoard[8] = board[2];
				symmetricBoardString = new String(symmetricBoard);
				if (!symmetricList.contains(symmetricBoardString))
					symmetricList.add(symmetricBoardString);
				System.arraycopy(symmetricBoard, 0, board, 0, board.length);
			}
		}
		return symmetricList;

	}

	/**
	 * Make a move and generate all subsequent moves from a board and given the
	 * player to move.
	 * 
	 * @param board
	 *            contains X's and O's and there are some number of spaces on
	 *            the board as specified by <code>spacesFree</code>
	 * @param spacesFree
	 *            the number of spaces in parameter <code>board</code>, i.e.,
	 *            non X/O characters
	 * @param toMove
	 *            is either 'X' or 'O' depending on who is to move
	 */

	private void makeMove(char[] board, int spacesFree, char toMove)

	{
		char nextToMove = 'O'; // next character to move
		if (toMove == 'O') { // 'O' about to move?
			nextToMove = 'X'; // 'X' goes next if 'O' goes now
		}

		if (hasWon(board, 'O')) {
			winForO.add(new String(board));
			return;
		}

		if (hasWon(board, 'X')) {
			winForX.add(new String(board));
			return;
		}

		if (spacesFree != 0) { // some place to go?

			int len = board.length;

			// look at all 9 board locations, for each one
			// that's a space, put the toMove character in
			// that location, then recurse with one less
			// free location. When the recursion returns,
			// undo the placing of the toMove character
			// by making it a space, then continue looking
			// for the next location in which toMove char
			// could be placed

			for (int k = 0; k < len; k++) {
				if (board[k] == SPACE) {
					board[k] = toMove;
					process(board); // record another board
					// if board

					makeMove(board, spacesFree - 1, // one less location free
							nextToMove);

					board[k] = SPACE; // undo move, continue
				}
			}
		}
	}

	public void genBoards() {
		String allBlank = "         "; // 9 spaces
		makeMove(allBlank.toCharArray(), 9, 'X');
	}

	private boolean hasWon(char[] board, char move) {

		int len = board.length;

		for (int i = 0; i < len; i = i + 3) {
			if ((board[i] == move) && (board[i + 1] == move)
					&& (board[i + 2] == move)) {
				return true;
			}
		}

		for (int j = 0; j < 3; j++) {
			if ((board[j] == move) && (board[j + 3] == move)
					&& (board[j + 6] == move)) {
				return true;
			}
		}

		if ((board[0] == move) && (board[4] == move) && (board[8] == move)) {
			return true;
		}

		if ((board[2] == move) && (board[4] == move) && (board[6] == move)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Tic tt = new Tic();
		tt.genBoards();
		tt.eliminateSymmetricBoards();
		tt.printResults();
	}
}
