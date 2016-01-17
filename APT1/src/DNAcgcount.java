
public class DNAcgcount
{
    public double ratio(String dna){
       double count=0;
       if (dna.length()==0)
    	   return 0;
       else
    	for(int i=0; i<dna.length(); i++){
    	if (dna.charAt(i)=='g')
    			count++;
    	else if (dna.charAt(i)=='c')
    	 	count++;}
    	
    	 	double ratio=count/dna.length();
    	 	
    	 	return ratio;   	 	
    	 	    }        
}
