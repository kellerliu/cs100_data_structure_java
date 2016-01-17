import java.util.*;


public class Example3 {
    
    public static void main(String[] args) {
        // this function sorts numbers by their remainder
        // when divided by 7
        
        //but it's broken
        //it can be fixed by swapping two lines
        
        HashMap<Integer, ArrayList<Integer>> remainders = new HashMap<Integer,ArrayList<Integer>>();
        //ArrayList<Integer> emptyList = new ArrayList<Integer>();
        
        for(int i = 1; i <= 100; i++) {

            int remainder = i % 7;
            if(!remainders.containsKey(remainder)) {
                // this is the first time we've found this remainder
                // we need to add it as a key to our HashMap      
            	ArrayList<Integer> emptyList = new ArrayList<Integer>();
                remainders.put(remainder, emptyList);
            }
            ArrayList<Integer> listForRemainder = remainders.get(remainder);
            listForRemainder.add(i);
            //this line is completely unnecessary, but it is not the problem
            remainders.put(remainder, listForRemainder);
            
        }
        System.out.println("Multiples of 7 are: " + remainders.get(0));
        System.out.println("Multiples of 7 plus 4 are : " + remainders.get(4));
    }
}
