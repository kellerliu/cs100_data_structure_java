import java.util.*;

public class Tourney {
	public String winner(String[] bracket, String results) {
		// fill in code here
		String ret;
		Queue<String> players = new LinkedList<String>();

		for (int i = 0; i < bracket.length; i++) {

			players.add(bracket[i]);
		}
		
		
		
		
		
		

		while (!results.isEmpty()) {

			String head = players.remove();
			String next = players.remove();

			if (head.equals("bye"))
				players.add(next);
			// important to have else here
			else if (next.equals("bye"))
				players.add(head);

			else {
				if (results.charAt(0) == 'H')
					players.add(head);
				else
					players.add(next);

				results = results.substring(1);
			}
		}
		//last bye is not shown in results and need to be removed
		if(players.peek().equals("bye"))	

			players.poll();
		
		ret=players.poll();
		
		
		

		return ret;

	}
}
