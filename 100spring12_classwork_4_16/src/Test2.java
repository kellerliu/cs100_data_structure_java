import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


public class Test2 {

    /*************
     * PilesList is a game played with 2 players.  The game begins with 
     * several piles of tokens.  Each turn, a player must remove 1 or 2 
     * tokens from 1 pile.  If a pile contains 0 elements, it can no longer 
     * be used.  A player loses if they can't move (because all the piles 
     * are 0).    Write a function whoWinsPilesList that takes an arrayList 
     * of piles and determines if player 1 will win or player 2 will win 
     * (assuming both sizes play perfectly).
     *
     * Examples:
     * [2,0,0] returns 1 because player 1 can just grab the 2
     * [1,1] returns 2 because player 1 must remove one pile and player 2 will remove the other
     * [] returns 2 (player one can't move)
     * [2,1] returns 1 because player 1 can subtract 1 from the 1st pile
     */
    
     public int whoWinsPilesList(ArrayList<Integer> piles) {
    		 for(int i=0;i<piles.size();i++){
    		 int current=piles.get(i);
    		 if(current>=2){
    		 piles.set(i,current-2);
    		 int t1=whoWinsPilesList(piles);
    		 piles.set(i, current);
    		 if(t1==2)
    			 return 1;
    		 }
    		 else if(current>=1){
    		 piles.set(i,current-1);
    		 int t2=whoWinsPilesList(piles);
    		 piles.set(i, current);
    		 if(t2==2)
    			 return 1;
    		 }    		 
    	 }
         return 2;    
     }
          
     
     
     /*************************
      * The function getMissingParens takes a String that contains only 
      * the following 4 characters: '(' ')' '[' ']'.  It returns a String
      *  that is whatever characters are necessary to "finish" the given 
      *  string such that all the parens match.  Note that '(' only 
      *  matches with ')' and '[' only matches with ']'.  If it is 
      *  impossible to finish the string such that all the parens match, 
      *  the function should return null.
      *  
      *  Examples:
      *  "(" should return ")"
      *  "([(" should return ")])"
      *  "()([]" should return ")"
      *  "()()()[]" should return ""
      *  "([)" should return null 
      */
     
     //we've built two useful functions for you
     public boolean isOpening(char a) { return (a == '(') || (a == '['); }
     public char matchingClose(char a) {
         if(a == '(') { return ')';  } else { return ']';  }
     }     
     
     public  String getMissingParens(String input) {
    	 Stack<Character> s=new Stack<Character>();
    	 for(int i=0;i<input.length();i++){
    		 char c=input.charAt(i);
    		 if(isOpening(c)){
    			 s.push(c);    			 
    		 }
    		 else{
    		 if(s.isEmpty())
    			 return null;
    		 else if (matchingClose(s.pop())!=c)	 
    			 return null;
    		 }    		 
    	 }
    	 String str="";
    	 while(!s.isEmpty()){
    		 str=str+matchingClose(s.pop());    		 
    	 }
    	 
    	 
    	 
         return str;
     }
     
     
     public static ArrayList<Integer> toList(int[] in) {
         ArrayList<Integer> result = new ArrayList<Integer>();
         for(int i : in) {
             result.add(i);
         }
         return result;
     }
     
     public static void main(String[] args) {
         
         Test2 t2 = new Test2();
         int[] d1 = {1,2};
         int[] d2 = {1,1};
         int[] d3 = {2,2};
         int[] d4 = {3,6,4};
         System.out.println("piles [1,2] (should be 1): " + t2.whoWinsPilesList(toList(d1)));
         System.out.println("piles [1,1] (should be 2): " + t2.whoWinsPilesList(toList(d2)));
         System.out.println("piles [2,2] (should be 2): " + t2.whoWinsPilesList(toList(d3)));
         System.out.println("piles [3,6,4] (should be 1): " + t2.whoWinsPilesList(toList(d4)));
         
         
         System.out.println(t2.getMissingParens("[][["));
     }
}


/***********************
* hints 
* **********************

For whoWinsPilesList...

The basic approach is

for(each item in pileslist)
   if(item is greater than 0)
       subtract 1 from that pile (easiest to use arraylist's SET method)
       result = call function recursively
       add 1 to that pile (backtracking)
       if(result == 2)...I win, return 1
   if(item is greater than 1)
       subtract 2 from that pile (easiest to use arraylist's SET method)
       result = call function recursively
       add 2 to that pile (backtracking)
       if(result == 2)...I win, return 1

...if there are no results that win 2 for all my recursive calls
return 2
*/
