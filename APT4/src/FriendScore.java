import java.util.*;

public class FriendScore {
	public int highestScore(String[] friends) {
		// you fill in code here

		int ret = 0;

		int len = friends.length;

		ArrayList<ArrayList<Integer>> fList = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < len; i++) {

			ArrayList<Integer> ifriend = new ArrayList<Integer>();

			for (int j = 0; j < len; j++) {

				if (friends[i].charAt(j) == 'Y') {
					ifriend.add(j);
				}
			}

			fList.add(ifriend);
		}

		for (int k = 0; k < len; k++) {
			ArrayList<Integer> currentList = new ArrayList<Integer>();
			currentList.addAll(fList.get(k));

			int current = currentList.size();
			int max = currentList.size();

			for (int m = 0; m < current; m++) {

				int test = currentList.get(m);

				for (Integer p : fList.get(test)) {
					if (!currentList.contains(p) && (p != k)) {
						currentList.add(p);
						max++;
					}
				}
			}
			if (ret < max)
				ret = max;

		}

		return ret;
	}
}