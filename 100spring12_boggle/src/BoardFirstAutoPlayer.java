import java.util.ArrayList;
import java.util.List;

public class BoardFirstAutoPlayer extends AbstractAutoPlayer {

	@Override
	public void findAllValidWords(BoggleBoard board, ILexicon lex, int minLength) {
		// TODO: you write this code, decide when to stop the recursion
		clear();
		for (int r = 0; r < board.size(); r++) {
			for (int c = 0; c < board.size(); c++) {
				 IsWordStart(board, r, c, new ArrayList<BoardCell> (), "", lex,minLength); 
			}
		}
	}

	private void IsWordStart(BoggleBoard board, int row, int col,
			List<BoardCell> list, String preWord, ILexicon lex,int minLength) {
		
		if (isOffBoard(board, row, col))
			return;
		
		BoardCell testBoard=new BoardCell(row, col);
		if(list.contains(testBoard))
			return;				
	
		String letterOnCell = board.getFace(row, col);
		String testWord = preWord + letterOnCell;

		if (lex.wordStatus(testWord) == LexStatus.NOT_WORD) 
			return;
		
		list.add(testBoard);
		
		if (lex.wordStatus(testWord) == LexStatus.WORD && testWord.length() >= minLength) 
			add(testWord);
				
		int[] rdelta = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] cdelta = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int k = 0; k < rdelta.length; k++) {
			IsWordStart(board, row + rdelta[k], col + cdelta[k], list, testWord, lex,minLength);	
		}

		list.remove(testBoard);
		int len=testWord.length();
		testWord=testWord.substring(0,len-letterOnCell.length());
		return;
	}

	private boolean isOffBoard(BoggleBoard board, int row, int col) {
		return row < 0 || row >= board.size() || col < 0 || col >= board.size();
	}
}
