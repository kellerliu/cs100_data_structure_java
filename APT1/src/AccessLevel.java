
public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
       String access="";
    	if (rights.length==0)
    		return access;
    		
    		for(int i=0; i<rights.length;i++){
    			if(rights[i]>=minPermission)
    				access=access+"A";
    				else 
    					access=access+"D";
        }
    	
    	    	return access;
    	
 }
    
}