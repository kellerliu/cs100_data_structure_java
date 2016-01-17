import java.util.*;

public class IsomorphicWords {
	Map<Character, Character> myMap;

	public int countPairs(String[] words) {
		int count = 0;
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				myMap = new HashMap<Character, Character>();
				if (IsomorphicJudge(words[i], words[j]))
					count++;
			}

		}
		return count;
	}

	public boolean IsomorphicJudge(String word1, String word2) {
		if (word1.length() == 0)
			return true;
		char char1 = word1.charAt(0);
		char char2 = word2.charAt(0);
		if (!myMap.containsKey(char1) && !myMap.containsValue(char2)) {
			myMap.put(char1, char2);
			return IsomorphicJudge(word1.substring(1), word2.substring(1));
		} else if (myMap.containsKey(char1)) {
			if (myMap.get(char1) == char2) {
				return IsomorphicJudge(word1.substring(1), word2.substring(1));
			}
			return false;
		}
		return false;
	}

}
