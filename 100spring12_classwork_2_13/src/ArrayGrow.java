
public class ArrayGrow {
    private String[] myWords = null;
    private int myIndex = 0; // location of first unused index in myWords
    /**
     * Add a value to storage, extending storage as needed.
     * @param word added to storage
     */
    public void add(String word) {
        if (myIndex >= myWords.length) {
            int newlen = (int) (myWords.length + 1); 
            String[] temp = new String[newlen];
            System.arraycopy(myWords,0,temp,0,myWords.length);
            myWords = temp;
        }
        myWords[myIndex] = word;
        myIndex += 1;
    }
    
    public void runTests() {
        for(int size = 10000; size <= 100000; size += 10000) {
            myWords = new String[1000];
            myIndex = 0;
            double start = System.currentTimeMillis();
            for(int k=0; k < size; k += 1) {
                add("word"+k);
            }
            double end = System.currentTimeMillis();
            System.out.printf("%d\t%f\n",size,(end-start)/1000);
            for(int k=0; k < size; k += 1) {
                if (! myWords[k].equals("word"+k)){
                    System.out.printf("word fail on %d at %d\n",size,k);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayGrow ag = new ArrayGrow();
        ag.runTests();
    }
}
