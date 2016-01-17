import java.util.*;

	public class Encryption {
       public String encrypt(String message){  
  	   // you write code here
       
    	char[]messages=message.toCharArray();

    	HashMap<Character, Character> abcMap=new HashMap<Character,Character>();
    	Character alphabeta='a';
    	String output="";
    	
    	for (int i=0;i<messages.length;i++)
    	{
    	  Character messageletter=new Character(messages[i]);
    	  if ( !abcMap.containsKey (messageletter))
    	  {
    		abcMap.put(messageletter,alphabeta);  
    		output+=alphabeta;
    		alphabeta++;
   	  	  }
    	  else 
    	  output+=abcMap.get(messageletter);
    	
    	
    	}
    	
    	return output;
    	   
    	   
       
       
   	   // you write code here
     
       }
   }