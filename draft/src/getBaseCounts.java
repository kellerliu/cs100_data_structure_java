import java.util.HashMap;

public class getBaseCounts {
	public HashMap <Character, Integer> count(String myData){


		HashMap<Character,Integer> baseCounts= new HashMap<Character,Integer>();

		baseCounts.put('c',0);
		baseCounts.put('g',0);
		baseCounts.put('a',0);
		baseCounts.put('t',0);


		for(int i=0; i<myData.length();i++){
			char currentBase=myData.charAt(i);
			if(baseCounts.containsKey(currentBase)){
				baseCounts.put(currentBase, baseCounts.get(currentBase)+1);
			}
		}

		return baseCounts;
	}

}



