import java.util.*;

public class WordLadder {

	private boolean isConnectedWords(String a, String b) {
		if (a.length() != b.length())
			return false;
		char[] Aarray = a.toCharArray();
		char[] Barray = b.toCharArray();
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (Aarray[i] != Barray[i])
				count++;
		}
		if (count == 1)
			return true;
		return false;
	}

	public String ladderExists(String[] words, String from, String to) {

		LinkedList<String> wordList = new LinkedList<String>();

		wordList.add(from);

		while (!wordList.isEmpty()) {

			String head = wordList.remove();

			for (int j = 0; j < words.length; j++) {

				if (isConnectedWords(words[j], head)) {
					wordList.add(words[j]);
					words[j]="";
				}
			}

			if (isConnectedWords(head, to) && (!head.equals(from)))

				return "ladder";
		}
		return "none";
	}
}
