
public class Rec8Prep {
	private int myRows, myCols;
	private char[][] myGrid;

	public boolean doesPathExist(char[][] grid, int ratRow, int ratCol) {
		myGrid = grid;
		myRows = grid.length;
		myCols = grid[0].length;

		return findPathStartingAt(ratRow, ratCol);
	}

	public boolean findPathStartingAt(int row, int col) {
		
		if (isOffBoard(row, col)) {
			return false;
		}
		
		if(myGrid[row][col]=='X'/* we're walking through a wall - write this check yourself*/)  {
			//we can't walk through walls so there's not a path starting at this wall
			return false;
		}
		
		//also check to make sure this square has not been visited already
		 if(myGrid[row][col] == 'v')
			 return false;
		//also make sure you check for cheese 
			 if(myGrid[row][col] == 'C')
				 return true;
		//ok, there's no wall here so we can mark this square as visited
		myGrid[row][col] = 'v';
		// fill in the rest here...

		boolean exist= findPathStartingAt(row-1,col)|| findPathStartingAt(row+1,col)||findPathStartingAt(row,col-1) ||findPathStartingAt(row,col+1);
		
		myGrid[row][col] = '.';

		return exist;
	}
	
	public boolean isOffBoard(int row, int col) {
		return row < 0 || row >= myRows || col < 0 || col >= myCols;
	}


	public char[][] convertTo2DArray(String[] configuration) {
		int rows = configuration.length;
		int cols = configuration[0].length();
		char[][] grid = new char[rows][cols];

		for (int r=0; r<rows; r++)
		{
			for (int c=0; c<cols; c++)
			{
				char ch=configuration[r].charAt(c);
				grid[r][c]=ch;
			}
		}

		return grid;
	}

	public static void main(String[] args) {
		Rec8Prep prep = new Rec8Prep();

		String[] case1 = {	".....",
				"..X..",
				"....X",
				".XXXX",
		".X.C."};

		String[] case2 = { 	".....",
				"..X..",
				"....X",
				"X.X.X",
		"...C."};

		String[] case3 = { 	"....",
				"....",
				"XXXX",
		"...C"};

		String[] case4 = {	".X.",
				"XX.",
		"C.."};

		System.out.println(prep.doesPathExist(prep.convertTo2DArray(case1), 0, 1));
		System.out.println(prep.doesPathExist(prep.convertTo2DArray(case2), 0, 1));
		System.out.println(prep.doesPathExist(prep.convertTo2DArray(case3), 1, 0));
		System.out.println(prep.doesPathExist(prep.convertTo2DArray(case4), 0, 0));
		
		//Output should be: false, true, false, false
	}
}

