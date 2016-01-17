import java.util.LinkedList;

public class AllWordLadders {

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

		return count==1;
	}

	public int[] solve(String[] words, String from, String to) {
		int[] solve = { 0, 0 };
		LinkedList<LinkedList<String>> wordList = new LinkedList<LinkedList<String>>();
		LinkedList<String> initialState = new LinkedList<String>();
		initialState.add(from);
		wordList.add(initialState);
		boolean first = true;
		while (!wordList.isEmpty()) {
			LinkedList<String> currentList = wordList.removeFirst();
			String lastState = currentList.getLast();

			if ((!lastState.equals(from)) && isConnectedWords(lastState, to)) {

				if (first) {

					solve[0] = currentList.size() + 1;
					first = false;
				}

				if ((currentList.size() + 1 == solve[0])) {

					solve[1]++;
				}

			}

			if ((!first) && (currentList.size() + 1 > solve[0]))
				return solve;

			for (String temp : words) {

				if (isConnectedWords(lastState, temp)
						&& (!currentList.contains(temp))) {
					LinkedList<String> newList = new LinkedList<String>(
							currentList);
					newList.add(temp);
					wordList.add(newList);
				}

			}

		}

		return solve;
	}

	

}



