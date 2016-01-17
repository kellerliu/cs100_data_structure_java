import java.util.*;

public class MedalTable {
	private static class Winner implements Comparable<Winner> {
		private String myWin;
		private int my1, my2, my3;

		public Winner(String winner, int[] medals) {
			myWin = winner;
			my1 = medals[0];
			my2 = medals[1];
			my3 = medals[2];
		}

		public int compareTo(Winner other) {
			if (my1 != other.my1)
				return other.my1 - my1;
			if (my2 != other.my2)
				return other.my2 - my2;
			if (my3 != other.my3)
				return other.my3 - my3;
			return myWin.compareTo(other.myWin);
		}

		public String toString() {
			return myWin + " " + my1 + " " + my2 + " " + my3;
		}
	}
	
	
	
	public String[] generate(String[] results) {
		// you fill in this code

		HashMap<String, int[]> MedalMap = new HashMap<String, int[]>();
		ArrayList<Winner> WinnersList = new ArrayList<Winner>();

		//create Map
		for (String temp : results) {
			String[] winners = temp.split(" ");
			for (int i = 0; i < 3; i++) {
				if (!MedalMap.containsKey(winners[i])) {
					int[] medals = new int[3];
					MedalMap.put(winners[i], medals);
					medals[i] = 1;
				}
				else
					(MedalMap.get(winners[i]))[i]++;
			}

		}

		//Create Winners ArrayList
		for (String temp2 : MedalMap.keySet()) {
			WinnersList.add(new Winner(temp2, MedalMap.get(temp2)));

		}

		Collections.sort(WinnersList);
		
		int numOfWinners = WinnersList.size();
		
		String[] result = new String[numOfWinners];
		for (int j = 0; j < numOfWinners; j++) {
			result[j] = WinnersList.get(j).toString();
		}

		return result;
	}

}
