import java.util.HashSet;

 public class SandwichBar
   {
      public int whichOrder(String[] available, String[] orders){
    	  
			 		 HashSet<String> uniavailable=new HashSet<String>();
					 for (String temp:available)
					 uniavailable.add(temp);
					 //get unique inventory available
		 
					 
			int i;
			
			for(i=0;i<orders.length;i++)
			{
    		  String temp=orders[i];
   		      String []splitorder = temp.split(" ");
   		   	  //split string into string array
    	
    		  boolean fit=true;
    		  for (String test:splitorder)
    		  {
    			  if(!uniavailable.contains(test))
    			  {fit=false;
    			  break;}
    		  }
    		
    		  //for(int j=0;j<splitorder.length;j++)
    		  	//{
    			  //if(!uniavailable.contains(splitorder[j]))
    			  	//{
    				  //fit=false;
    				  //break;
    				  //}
      		  	//}
    		  
    		  if(fit){
    			  return i;
    			  //break;
   		 		  }
			}
			
			return -1;
   		   	  
   		   		  
   		   		    	
      }   	  
      
   }
			
			
   		   	  
      
      
      
      
    	    	       
   
   
   
   
   
    	  
