import java.util.*;


public class Rec7Prep
{

    public void reverseTopK(Stack<String> stack, int k)
    {
        //your code goes here
    	
    	Stack<String> top1=new Stack<String>();
    	Stack<String> top2=new Stack<String>();

    	for(int i=0;i<k;i++){
    		top1.push(stack.pop());
    	}
    	
    	for(int j=0;j<k;j++){
    		top2.push(top1.pop());   		
    	}
    	
    	for(int m=0;m<k;m++){
    	stack.push(top2.pop());
    	}
    	
    	
    }
    
    public static void main(String[] args)
    {
        Rec7Prep p = new Rec7Prep();
        
        
        Stack<String> test = new Stack<String>();
        test.push("ninja");
        test.push("robot");
        test.push("mime");
        test.push("pirate");
        test.push("hamster");

        // Should output [ninja, robot, mime, pirate, hamster] <- top 
        System.out.println(test + " <- top");
        
        p.reverseTopK(test, 4);
        
        
        // Should output [ninja, hamster, pirate, mime, robot] <- top
        System.out.println(test + " <- top");
    }
}
