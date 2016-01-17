
import java.util.*;

/**
 * This is a skeleton program, you'll
 * need to modify, either adding code in main
 * or in functions called from main
 * @author YOUR NAME HERE
 *
 */

public class HangmanStats {
	public static void main(String[] args) {
		HangmanFileLoader loader = new HangmanFileLoader();
		loader.readFile("lowerwords.txt");
		
		HashSet<String> set = new HashSet<String>();
		for(int i=4;i<21;i++){
		  for(int k=0; k < 10000; k += 1) {
			set.add(loader.getRandomWord(i));
		}
		  System.out.printf("number of %d letter words = %d\n", i,set.size());
		  set.clear();
		}
	}
}