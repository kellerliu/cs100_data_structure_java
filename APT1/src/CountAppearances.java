
public class CountAppearances {
     public int numberTimesAppear(int number, int digit) {
         int count=0;
    	 int temp=number;
  	   	 for (;temp >=1;)
    	 {
    		int l=temp%10;
    		if (digit==l)
    			count++;
           	 temp=temp/10;
    	 }
     	 return count;
    	   	 
    	 
     }
   }