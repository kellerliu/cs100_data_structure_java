import java.util.*;

public class HangmanTimes {
	public static void main(String[] args) {
		HangmanFileLoader loader = new HangmanFileLoader();
		loader.readFile("lowerwords.txt");
		
		for(int i=4;i<21;i++)
		{
			int limit=100;
			for (int m=0;m<10;m++){
	
			int[]calls=new int[limit];
			for (int j=0;j<limit;j++)
			  {
				ArrayList<String> wordlist=new ArrayList<String>();
				for(int k=0; k < limit; k ++) 
						{
						String loopword=loader.getRandomWord(i);
						if(!wordlist.contains(loopword))
							wordlist.add(loopword);
						else break;
						}
				calls[j]=wordlist.size()+1;
			  }
			
			int total = 0;
			for(int temp:calls)
				total+=temp;						
				
			double ave=total/limit;
									
		//System.out.println(limit+ " tests show that " +ave+" calls of "+i+"-letter words are needed ");
			System.out.println( ave+"");

			limit*=2;
			}
		
		}
	}
}