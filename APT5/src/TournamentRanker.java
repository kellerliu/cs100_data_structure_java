import java.util.*;

public class TournamentRanker {

	private static class team implements Comparable<team> {
		private String myName;
		private team mylostToTeam;
		private int myWin;

		public team(String name) {
			myName = name;
		}

		public String getName() {
			return myName;
		}

		public void setlost(team lostTo) {
			mylostToTeam = lostTo;
		}

		public void setwin(int win) {
			myWin = win;
		}

		public int compareTo(team other) {
			if (myWin != other.myWin)
				return other.myWin - myWin;

			return mylostToTeam.compareTo(other.mylostToTeam);
		}

	}

	public String[] rankTeams(String[] names, String[] lostTo) {
		// fill in code here
		int teamNum = names.length;
		ArrayList<team> teamList = new ArrayList<team>();
		String[] rankTeams = new String[teamNum];

		for (int i = 0; i < teamNum; i++) {
			team current = new team(names[i]);
			int count = 0;
			for (String tempwin : lostTo) {

				if (tempwin.equals(names[i]))
					count++;

			}
			current.setwin(count);
			teamList.add(current);

		}

		for (int j = 0; j < teamNum; j++) {

			String test = lostTo[j];
			for (team temp : teamList) {
				if (temp.getName().equals(test)){
					teamList.get(j).setlost(temp);
				break;
				}
			}
		}

		Collections.sort(teamList);

		for (int k = 0; k < teamNum; k++) {
			rankTeams[k] = teamList.get(k).getName();
		}

		return rankTeams;

	}

}
