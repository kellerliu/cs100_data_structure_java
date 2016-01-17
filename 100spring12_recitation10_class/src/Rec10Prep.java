import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Rec10Prep {

	public int sumNSmallest(Scanner s, int n) {
		PriorityQueue<Integer> numbers = new PriorityQueue<Integer>();

		while (s.hasNextInt()) {
			int next = s.nextInt();
			numbers.add(next);
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum+=numbers.poll();
		}
		return sum;
	}



	public static void main(String[] args) {
		Rec10Prep r = new Rec10Prep();

		try {
			Scanner s = new Scanner(new File("data1.txt"));
			System.out.println(r.sumNSmallest(s, 4));
			s = new Scanner(new File("data2.txt"));
			System.out.println(r.sumNSmallest(s, 5));
			s = new Scanner(new File("data3.txt"));
			System.out.println(r.sumNSmallest(s, 3));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		/* Output should be
		  	23
			15
			10
		 */

	}
}
