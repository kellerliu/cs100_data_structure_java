import java.util.HashMap;

public class BSTcount {
	HashMap<Integer, Long> solvedTrees = new HashMap<Integer, Long>();
	
	public long howMany(int[] values) {
		return treeCounts(values.length);
	}

	private long treeCounts(int n) {
		long answer=0;
		if (n == 0||n==1)
			return 1;
		
		if (solvedTrees.containsKey(n))
		return solvedTrees.get(n); 
		
		for(int i=0;i<n;i++) {
			answer =answer+ treeCounts(i) * treeCounts(n-1-i);
		}
		solvedTrees.put(n, answer);
		return answer;		
	}

//	public static void main(String[] args) {
//		BSTcount g = new BSTcount();
//		int[] array1 = { 1,2 };
//		int[] array2 = { 1,2,3 };
//		int[] array3 = { 1,2,3 };
//		int[] array4 = { 1,2,3,4 };
//		int[] array5 = { 1,2,3,4,5 };
//
//		System.out.println("2 nodes have tree number " + g.howMany(array1));
//		System.out.println("3 nodes have tree number " + g.howMany(array2));
//		System.out.println("4 nodes have tree number " + g.howMany(array3));
//		System.out.println("5 nodes have tree number " + g.howMany(array4));
//		System.out.println("6 nodes have tree number " + g.howMany(array5));

//	}

}
