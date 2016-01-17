public class SumOfN {

	public int CalSum(int n) {

		if (n == 1)
			return 1;
		return CalSum(n - 1) + n;

	}

	public int NumOfX(String s) {

		if (s.isEmpty())
			return 0;
		String restOfString = s.substring(1);
		int restOfStringCount = NumOfX(restOfString);
		if (s.charAt(0) == 'a') {
			return restOfStringCount + 1;
		} else
			return restOfStringCount;
	}

	public boolean isPallindrome(String input) {

		if (input.length() <= 1)
			return true;
		if (input.charAt(0) != input.charAt(input.length() - 1))
			return false;
		return isPallindrome(input.substring(1, input.length() - 1));

	}
	
	
	
	
	
	
	public static void main(String[] args) {
		SumOfN ex = new SumOfN();
		int numToTest = 3;

	//	System.out.println("Sum from 1 to " + numToTest + " is "
	//			+ ex.CalSum(numToTest));
				
				
				
				
				
		System.out.println(ex.isPallindrome("m123321m"));
				
	}



}
