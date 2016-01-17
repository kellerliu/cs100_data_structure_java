
public class NumbersGame2Player {

	public boolean willFirstPlayerWin(int startingNum) {

		
		if(startingNum<=3)
			return true;

		if(!willFirstPlayerWin(startingNum-1))
				return true;
			
		if(!willFirstPlayerWin(startingNum-2))
			return true;
		
		if(!willFirstPlayerWin(startingNum-3))
			return true;
			
			
			
		return false;			
	
			
	}
	
	public static void main(String[] args) {
		NumbersGame2Player p = new NumbersGame2Player();
		for(int i = 1; i <= 20; i++) {
			//in 1 - 10, only 4 and 8 happen to be unwinnable
			System.out.println(i + ": " + p.willFirstPlayerWin(i));
		}
	}
}
