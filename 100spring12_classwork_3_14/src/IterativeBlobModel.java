import java.util.*;

public class IterativeBlobModel extends BlobModel {

    public class Pair{
        int row;
        int col;
        public Pair(int r, int c){
            row = r;
            col = c;
        }
        @Override
        public boolean equals(Object o){
            Pair p = (Pair) o;
            return row == p.row && col == p.col;
        }
        @Override
        public int hashCode(){
            return row*1000+col;
        }
    }
    
    Pair[][] myPairGrid;
    Queue<Pair> myQueue = new LinkedList<Pair>();
    
    @Override
    public void initialize(int rows, int cols, int count){
        super.initialize(rows,cols,count);
        myPairGrid = new Pair[myGrid.length][myGrid[0].length];
        for(int r=0; r < myPairGrid.length; r++){
            for(int c=0; c < myPairGrid[0].length; c++){
                myPairGrid[r][c] = new Pair(r,c);
            }
        }
    }
    
    
    @Override
    protected int blobFill(int row, int col, int lookFor, int fillWith) {
    	
    	/*********
    	 * 
    	 * Right here, write a english language description of how this
    	 * algorithm works:
    	 * 
    	 * 
    	 * 
    	 */
    	
        int size = 0;
        int[] rowDelta = {-1,1,0,0}; //line 1
        int[] colDelta = {0,0,-1,1};
        
        if (myGrid[row][col] != lookFor) return 0; // not part of blob
        myQueue.clear();
        
        myGrid[row][col] = fillWith;  // mark pixel
        size++;                       // count pixel
        myQueue.add(myPairGrid[row][col]);  //line 2
        while (myQueue.size() != 0){ 
            Pair p = myQueue.remove();
            for(int k=0; k < rowDelta.length; k++){ // line 3
                row = p.row + rowDelta[k]; // line 4
                col = p.col + colDelta[k];
                if (inRange(row,col) && myGrid[row][col] == lookFor){
                    myQueue.add(myPairGrid[row][col]); //line 5
                    myGrid[row][col] = fillWith;
                    size++;
                }
            }
        }
        return size;
    }

}
