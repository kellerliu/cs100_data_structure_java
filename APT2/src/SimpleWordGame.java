import java.util.HashSet;


public class SimpleWordGame {
	 public int points(String[] player, String[] dictionary) {
// you write code here
		 HashSet<String> uniqueplayer=new HashSet<String>();
			 for (String tempplayer:player)
			 uniqueplayer.add(tempplayer);
		 
		 int points=0;
			 
			 for (String test: dictionary){	 
				 if (uniqueplayer.contains(test))
					  points+=(test.length())*(test.length()); 
			 										}
		 								
			 return points;}
	 }