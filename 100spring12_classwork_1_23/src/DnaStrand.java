import java.util.*;

public class DnaStrand {
    
	public int myInt;
    private String myData;
    
    DnaStrand()
    {
//    	myInt = 20;
//    	myData = "lalala";
    }
    
   DnaStrand (DnaStrand a) {
	   myData = a.myData;
	   myInt = a.myInt;
   }
    
    public String getStrandData() {
        return myData;
    }
    
    public void setStrandData(String newData) {
        myData = newData;
    }
    
    public void addBasePair(String newPair) {
        myData = myData + newPair;        
    }
    
    public boolean is3rdBasePairCytosine()
    {
        if(myData.charAt(2) == 'c')
            return true;
        return false;
    }
    
    public HashMap<Character,Integer> getBaseCounts()
    {
        HashMap<Character,Integer> baseCounts = new     
            HashMap<Character,Integer>();
        baseCounts.put('c', 0);
        baseCounts.put('g', 0);
        baseCounts.put('a', 0);
        baseCounts.put('t', 0);

      for(int i = 0; i < myData.length(); i++) {
           char currentBase = myData.charAt(i);
           int currentCount = baseCounts.get(currentBase);
           baseCounts.put(currentBase, currentCount + 1 );
      }
      return baseCounts;
    }

}
