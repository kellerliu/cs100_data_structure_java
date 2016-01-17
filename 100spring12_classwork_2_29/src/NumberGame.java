import java.util.LinkedList;
import java.util.Stack;


public class NumberGame {
    
    public boolean isWinnable1(int startingNum) {
       	LinkedList<Integer> nums=new LinkedList<Integer>();
    	nums.add(startingNum);
    	while(!nums.isEmpty()){
    		int current=nums.removeLast();
    		if(current==0) return true;
    		if(current>0) {
    			nums.add(current-7);
    			nums.add(current-9);
    			nums.add(current-20);
    			 			
    		}
    	}
        //if the list is empty, we've exhausted every possibility
        return false;
    }

    public boolean isWinnable2(int startingNum) {
    	LinkedList<Integer> nums=new LinkedList<Integer>();
    	nums.add(startingNum);
    	while(!nums.isEmpty()){
    		int current=nums.removeLast();
    		if(current==0) return true;
    		if(current>0) {
    			nums.add(current-3);
    			nums.add(current-20);
    			if(current%2==0)
    				nums.add(current/2);
    			 			
    		}
    	}
        return false;
    }
    
    public int goodMove3(int startingNum) {
		if(startingNum==0) return 0;

    	LinkedList<Integer> nums=new LinkedList<Integer>();
    	
    	nums.add(startingNum);
    	
    	while(!nums.isEmpty()){
    		int current=nums.removeFirst();

    		if(current==3) return 3;
    		if(current==7) return 7;
    		if(current==-1) return -1;
    		
    		
    		
    		if(current>0) {
    			nums.add(current-3);
    			nums.add(current-7);
   				nums.add(current+1);
    			 			
    		}
    	}
    	return 0;
        
    }

    public LinkedList<Integer> statesList2(int startingNum) {
                
        LinkedList<LinkedList<Integer>> nums = new LinkedList<LinkedList<Integer>>();
        LinkedList<Integer> initialState = new LinkedList<Integer>();
        initialState.add(startingNum);
        nums.add(initialState);
        while (!nums.isEmpty()) {
            LinkedList<Integer> currentList = nums.removeFirst();
            int lastState = currentList.getLast();
            //your code goes here
            if (lastState==0) 
            	return currentList;
            if (lastState>0){
            	LinkedList<Integer> newList =new LinkedList<Integer>(currentList);         
            	newList.add(lastState-3);
            	nums.add(newList); 
            	newList =new LinkedList<Integer>(currentList);   
            	newList.add(lastState-20);
            	nums.add(newList);            	
            	if(lastState%2==0){
            	newList =new LinkedList<Integer>(currentList);   
            	newList.add(lastState/2);
            	nums.add(newList);}            	
            } 	                
        }
        return null;        // if the list is empty, then this is not winnable
    }

    public boolean isParenMatch(String input) {
        Stack<Character> toMatch = new Stack<Character>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '[' || c == '(') {
                toMatch.push(c);
            } else if (!toMatch.isEmpty())// avoiding pop an empty stack, which causes error.
          {
                char match = toMatch.pop();
                if(match == '[' && c == ')')
                    return false;
                if(match == '(' && c == ']')
                    return false;
                
            }else return false;// this means, whenever the toMatch is or become empty, getting a char not ( or [ will be false. 
        }
        if(toMatch.isEmpty() == false)
            return false;
        return true;
    }
    
    public static void main(String[] args) {
        NumberGame g = new NumberGame();
        for(int i = 0; i < 30; i++) {
            
            //in the range 20-25, only 22 and 24 are not winnable
            if(g.isWinnable1(i)) {
                System.out.println("Game1 is winnable for " + i);
            }
            
          //in the range 20-25, only 22 and 25 are not winnable
            if(g.isWinnable2(i)) {
                System.out.println("Game2 is winnable for " + i);
            }
                        
        }
        
        int startingNum = 20;
        System.out.println("In game three, for " + startingNum);
        while(startingNum != 0) {
            int move = g.goodMove3(startingNum);
            startingNum -= move;
            System.out.print(move + " ");
        }
        System.out.println();        
        System.out.println("States for game 2 input 32 " + g.statesList2(32));
        System.out.println(g.isParenMatch("([[])"));
        
        System.out.println(g.isParenMatch("()))))"));

        
    }
}
