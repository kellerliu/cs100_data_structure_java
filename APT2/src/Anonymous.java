import java.util.ArrayList;



public class Anonymous {
      public int howMany(String[] headlines, String[] messages) {
    	  String headline="";
    	  for (String temp:headlines)
    		  	headline+=temp;
    	  String newheadline=headline.toLowerCase();

    	
    	  int number=0;
     	  
    	  for(int i=0;i<messages.length;i++)
       	  {
    		 
    		  ArrayList <Character> headlineletters=new ArrayList <Character>();
        	  for (char t: newheadline.toCharArray())
        	  {
        		  headlineletters.add((Character)t);
        	  }
    		  
        	  
            	  //change headlines into a char arraylist;
    		  
    		  
       		  char [] messageletters= messages[i].trim().toLowerCase().toCharArray();
 
       		 boolean enough=true;
	       		// 	if(messageletters.length==0)
	       		 //	{ number++; continue;}		
       		  
       		  	for(char testletter:messageletters)
       		  	{
       		  		if(!headlineletters.remove((Character)testletter))
	       		  		{
       		  			enough=false;
	       		  		break;
	       		  		}
       		  	}
       		  
       		  if(enough) number++;
       		  	
       		 }
       			  
       		  
       	return number;		  
       		  
       		  
       	 
    	  
    	  
    	  
    	  // fill in code here
      }
   }