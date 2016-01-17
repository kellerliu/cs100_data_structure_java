import java.util.*;

public class SortedFreqs {

	public int[] freqs(String[] data) {
		ArrayList<String> sortList = new ArrayList<String>();
		Map<String, Integer> numMap = new HashMap<String, Integer>();

		for (String temp : data) {
			if (!sortList.contains(temp))
				sortList.add(temp);

			if (!numMap.containsKey(temp))
				numMap.put(temp, 1);
			else
				numMap.put(temp, numMap.get(temp) + 1);
		}
		Collections.sort(sortList);

		int s = sortList.size();

		int[] ret = new int[s];

		for (int i = 0; i < s; i++) {
			ret[i] = numMap.get(sortList.get(i));
		}

		return ret;

	}

}
