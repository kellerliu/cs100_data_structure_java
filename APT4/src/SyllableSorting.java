import java.util.*;

public class SyllableSorting {
	
	private static class word implements Comparable<word> {
		private String myString;
		private ArrayList<String> mySyllableList;
		
		public word(String s){
			myString = s;
			mySyllableList = getSyllables(myString);
		}
		
		private ArrayList<String> getSyllables(String oneword){
			char[] vowels = {'a','e','i','o','u'};
			HashSet<Character> vowelSet = new HashSet<Character>();
			for (char vowel:vowels){
				vowelSet.add(vowel);
			}
			ArrayList<String> SyllableList = new ArrayList<String>();
			char[] charList = oneword.toCharArray();
			int begin = 0;
			int end = 0;
			boolean vowelStart = false;
				while(end<oneword.length()){
					if (vowelSet.contains(charList[end])){
						vowelStart = true;
					}
					if ((vowelStart)&&(!vowelSet.contains(charList[end]))){
						SyllableList.add(oneword.substring(begin,end));
						begin=end;
						vowelStart = false;
					}
						end++;
				}
				SyllableList.add(oneword.substring(begin));
				return SyllableList;
			}
					
		public int compareTo(word other){
			ArrayList<String> SortedmySyllable = new ArrayList<String>(mySyllableList);
			ArrayList<String> SortedotherSyllable = new ArrayList<String>(other.mySyllableList);
			Collections.sort(SortedmySyllable);
			Collections.sort(SortedotherSyllable);
			int size1 = mySyllableList.size();
			int size2 = other.mySyllableList.size(); 
			int minsize = Math.min(size1, size2);
			for (int i = 0; i<minsize; i++){
				if (!SortedmySyllable.get(i).equals(SortedotherSyllable.get(i)))
					return SortedmySyllable.get(i).compareTo(SortedotherSyllable.get(i));
			}
			if (size1!=size2)
				return size1-size2;
			for (int j = 0; j<minsize; j++){
				if (!mySyllableList.get(j).equals(other.mySyllableList.get(j)))
					return mySyllableList.get(j).compareTo(other.mySyllableList.get(j));	
			}
			return 0;
		}
		
		public String toString(){
			return myString;
		}
	}
	
	public String[] sortWords(String[] words) {
		ArrayList<word> wordList = new ArrayList<word>();
		String[] result = new String[words.length];

		for (String t:words){
			wordList.add(new word(t));
		}
		Collections.sort(wordList);
		for (int k = 0; k < words.length; k++)
			result[k] = wordList.get(k).toString();
		return result;		
	}
}
