import java.util.*;


public class SpreadingNews {
	public int minTime(int[] supervisors) {
		int minimumTime = 0;
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		int size = supervisors.length;
		if (size == 1)
			return 0;
		for (int index=0; index<size; index++) {
			if (supervisors[index] == 0) {
				int[] subordinates = new int[size-index];
				for (int i = 0; i < size-index; i++) {
					subordinates[i] = supervisors[i+index] - index;
				}
				timeList.add(new Integer(minTime(subordinates)));
			}
		}
		
		Collections.sort(timeList);
		for (int i = 0; i < timeList.size(); i++) {
			minimumTime = Math.max(timeList.get(i) + timeList.size() - i,
					minimumTime);
		}
		return minimumTime;

	}
}
