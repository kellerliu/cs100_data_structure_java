public class PrefixCode { 
      public String isOne(String[] words) {
    	  
    	  
    	  int wordnum=words.length;
    	  
    	for(int i=0;i<wordnum;i++)
    		
    	{
    		
    		for (int j=0;j<wordnum;j++)
    		{
    			if (i==j) 
    				continue;
    			
    			if(words[j].startsWith(words[i]))
    				 return "No, "+i;
    		}
    			
    	}
    		
    
    		return "Yes";
   }
}