import java.util.*;

public class TicTac {
	private static char SPACE = ' ';

	ArrayList<String> myBoards;
	ArrayList<String> winForO;
	ArrayList<String> winForX;

	public TicTac() {
		myBoards = new ArrayList<String>();
		winForO = new ArrayList<String>();
		winForX = new ArrayList<String>();

	}

	public void printResults() {
		System.out.println("total # boards = " + myBoards.size()
				+ ", # wins for 'O' = " + winForO.size()
				+ ", # wins for 'X' = " + winForX.size());
		System.out.println();
		System.out.println("Unique boards:");
		Collections.sort(myBoards);
		int k=0;
		for (;k<myBoards.size()-1;k++) {
			System.out.println(myBoards.get(k));
		}
		
		System.out.print(myBoards.get(k));
		
	}

	public void process(char[] board) {
		String newBoard = new String(board);
		if (!myBoards.contains(newBoard))
			myBoards.add(newBoard);
		// if (myBoards.size() % 10000 == 0) {
		// System.out.println(myBoards.size());
		// }
	}

	private void makeRealMove(char[] board, int spacesFree, char toMove)

	{
		char nextToMove = 'O'; // next character to move
		if (toMove == 'O') { // 'O' about to move?
			nextToMove = 'X'; // 'X' goes next if 'O' goes now
		}

		if (winMove(board, 'O')) {
			String test = new String(board);
			boolean noSymmetry=true;
			if(!winForO.contains(test)){
			for (int i = 0; i < winForO.size(); i++) {
				String temp = winForO.get(i);
				if (symmetry(temp, test)) {
					noSymmetry = false;
					if (temp.compareTo(test) > 0) {
						winForO.remove(temp);
						winForO.add(test);
						i--;
					}
				}
			}

			if(noSymmetry)
			winForO.add(test);
			
			}
			return;
		}

		if (winMove(board, 'X')) {
			String test = new String(board);
			boolean noSymmetry=true;
			if(!winForX.contains(test)){
			for (int i = 0; i < winForX.size(); i++) {
				String temp = winForX.get(i);
				if (symmetry(temp, test)) {
					noSymmetry = false;
					if (temp.compareTo(test) > 0) {
						winForX.remove(temp);
						winForX.add(test);
						i--;
					}
				}
			}

			if(noSymmetry)
			winForX.add(test);
			
			}
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

					String test = new String(board);
					boolean noSymmetry = true;

					for (int i = 0; i < myBoards.size(); i++) {
						String temp = myBoards.get(i);
						if (symmetry(temp, test)) {
							noSymmetry = false;
							if (temp.compareTo(test) > 0) {
								myBoards.remove(temp);
								process(board);
								i--;
							}
						}
					}

					if (noSymmetry)
						process(board); // record another board

					makeRealMove(board, spacesFree - 1, // one less location
														// free
							nextToMove);

					board[k] = SPACE; // undo move, continue
				}
			}
		}
	}

	public boolean symmetry(String stringA, String stringB) {
		char[] boardA = stringA.toCharArray();
		char[] boardB = stringB.toCharArray();

		if (boardA[0] == boardB[2] && boardA[2] == boardB[0]
				&& boardA[3] == boardB[5] && boardA[5] == boardB[3]
				&& boardA[6] == boardB[8] && boardA[8] == boardB[6]
				&& boardA[1] == boardB[1] && boardA[4] == boardB[4]
				&& boardA[7] == boardB[7])
			return true;// horizontal
		if (boardA[0] == boardB[6] && boardA[6] == boardB[0]
				&& boardA[1] == boardB[7] && boardA[7] == boardB[1]
				&& boardA[2] == boardB[8] && boardA[8] == boardB[2]
				&& boardA[3] == boardB[3] && boardA[4] == boardB[4]
				&& boardA[5] == boardB[5])
			return true;// vertical
		if (boardA[1] == boardB[3] && boardA[3] == boardB[1]
				&& boardA[2] == boardB[6] && boardA[6] == boardB[2]
				&& boardA[5] == boardB[7] && boardA[7] == boardB[5]
				&& boardA[0] == boardB[0] && boardA[4] == boardB[4]
				&& boardA[8] == boardB[8])
			return true;// left/right-diagonal
		if (boardA[0] == boardB[8] && boardA[8] == boardB[0]
				&& boardA[1] == boardB[5] && boardA[5] == boardB[1]
				&& boardA[3] == boardB[7] && boardA[7] == boardB[3]
				&& boardA[2] == boardB[2] && boardA[4] == boardB[4]
				&& boardA[6] == boardB[6])
			return true;// right/left-diagonal
		if (boardA[0] == boardB[2] && boardA[1] == boardB[5]
				&& boardA[2] == boardB[8] && boardA[5] == boardB[7]
				&& boardA[8] == boardB[6] && boardA[7] == boardB[3]
				&& boardA[6] == boardB[0] && boardA[3] == boardB[1]
				&& boardA[4] == boardB[4])
			return true;// 90
		if (boardB[0] == boardA[2] && boardB[1] == boardA[5]
				&& boardB[2] == boardA[8] && boardB[5] == boardA[7]
				&& boardB[8] == boardA[6] && boardB[7] == boardA[3]
				&& boardB[6] == boardA[0] && boardB[3] == boardA[1]
				&& boardA[4] == boardB[4])
			return true;// 270
		if (boardA[0] == boardB[8] && boardA[1] == boardB[7]
				&& boardA[2] == boardB[6] && boardA[3] == boardB[5]
				&& boardA[4] == boardB[4] && boardA[5] == boardB[3]
				&& boardA[6] == boardB[2] && boardA[7] == boardB[1]
				&& boardA[8] == boardB[0])
			return true;// 180

		return false;

	}

	public boolean winMove(char[] board, char toMove) {
		if (board[0] == toMove && board[1] == toMove && board[2] == toMove)
			return true;
		if (board[3] == toMove && board[4] == toMove && board[5] == toMove)
			return true;
		if (board[6] == toMove && board[7] == toMove && board[8] == toMove)
			return true;

		if (board[0] == toMove && board[3] == toMove && board[6] == toMove)
			return true;
		if (board[1] == toMove && board[4] == toMove && board[7] == toMove)
			return true;
		if (board[2] == toMove && board[5] == toMove && board[8] == toMove)
			return true;

		if (board[0] == toMove && board[4] == toMove && board[8] == toMove)
			return true;
		if (board[2] == toMove && board[4] == toMove && board[6] == toMove)
			return true;

		return false;

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

	public void genRealBoards() {
		String allBlank = "         "; // 9 spaces
		makeRealMove(allBlank.toCharArray(), 9, 'X');

	}

	public static void main(String[] args) {
		TicTac tt = new TicTac();
		tt.genRealBoards();
		tt.printResults();
	}
}
