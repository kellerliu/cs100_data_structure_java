import java.util.*;

/**
 * This is a skeleton program, you'll
 * need to modify, either adding code in main
 * or in functions called from main
 * @author Junfei Liu
 *
 */

public class HangmanStats {
	public static void main(String[] args) {
		HangmanFileLoader loader = new HangmanFileLoader();
		loader.readFile("lowerwords.txt");
	
		
		for(int i=4;i<21;i++){
			HashSet<String> set = new HashSet<String>();
			int[] number=new int[10];
			int limit=1000;
				for (int j=0;j<10;j++)
				{
					for(int k=0; k < limit; k += 1) 
						{
						set.add(loader.getRandomWord(i));
						}
					number[j]=set.size();
					limit=limit*2;
				}
			
				for (int m=0;m<10;m++)
				
			System.out.printf("number of %d letter words = %d\n",i, number[m]);
				
					
		}
	}
}