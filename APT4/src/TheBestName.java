


import java.util.*;

public class TheBestName {
	
	private static class Name implements Comparable<Name>{
		
		private String myName;
		
		public Name(String name){
			myName = name;
		}
		
		public int compareTo(Name other){
			if(myName.equals("JOHN"))
				return -1;
			if(other.myName.equals("JOHN"))
				return 1;
						
			int mynum = 0;
			int othernum = 0;
			
			for(char temp:myName.toCharArray()){
				mynum += (int)(temp);
			}
			for(char temp:other.myName.toCharArray()){
				othernum += (int)(temp);
			}
			
			if(othernum-mynum!=0)
				return othernum-mynum;// to sort from big to small;
			return myName.compareTo(other.myName);
		}
	}
		
	public String[] sort(String[] names) {
		
		ArrayList<Name> namelist = new ArrayList<Name>();
		for (String name:names){
			namelist.add(new Name(name));
		}
		Collections.sort(namelist);

		String[] sortedArray = new String[names.length];
		
		for (int i=0;i<names.length;i++){
			sortedArray[i] = namelist.get(i).myName;
		}
		return sortedArray;
	}
	
}
