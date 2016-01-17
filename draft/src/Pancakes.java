
public class Pancakes {
     public int minutesNeeded (int numCakes, int capacity) {
     
    	 int pans= 2*numCakes/capacity;
    	 if (pans*capacity<2*numCakes)
    		 // if ((2*numCakes%capacity)!=0)    		 
    		 pans++;
    	 return 5*pans;    	 
    	 }
  }