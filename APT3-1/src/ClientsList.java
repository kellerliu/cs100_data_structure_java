import java.util.*;

public class ClientsList {

	public static class ClientName implements Comparable<ClientName> {

		private String myFirst, myLast;

		public ClientName(String first, String last) {
			myFirst = first;
			myLast = last;
		}

		public String printName() {
			return myFirst + " " + myLast;
		}

		public int compareTo(ClientName arg0) {
			if (!myLast.equals(arg0.myLast))
				return myLast.compareTo(arg0.myLast);
			if (!myFirst.equals(arg0.myFirst))
				return myFirst.compareTo(arg0.myFirst);
			return 0;
		}

	}

	public String[] dataCleanup(String[] names) {
		String FirstName = "";
		String LastName = "";
		int numOfNames = names.length;
		String[] cleanedNames = new String[numOfNames];
		ArrayList<ClientName> Namelist = new ArrayList<ClientName>();

		for (int i = 0; i < numOfNames; i++) {
			boolean rightorder = true;
			for (int j = 0; j < names[i].length(); j++) {
				if (names[i].charAt(j) == ',') {
					LastName = names[i].substring(0, j);
					FirstName = names[i].substring(j + 1).trim();
					rightorder = false;
					break;
				}

			}
			if (rightorder) {
				LastName = names[i].split(" ")[1];
				FirstName = names[i].split(" ")[0];
			}

			Namelist.add(new ClientName(FirstName, LastName));
		}
		Collections.sort(Namelist);
		for (int k = 0; k < numOfNames; k++) {
			cleanedNames[k] = Namelist.get(k).printName();
		}
		return cleanedNames;
	}

}
