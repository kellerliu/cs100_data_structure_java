public class count7 {

	public int count7(int n) {

		if (n == 0)
			return 0;

		if (n % 10 == 7)
			return count7(n / 10) + 1;
		else
			return count7(n / 10);

	}

	public int bunnyEars2(int bunnies) {

		if (bunnies == 0)
			return 0;
		if (bunnies % 2 == 0)
			return bunnyEars2(bunnies - 1) + 3;
		else
			return bunnyEars2(bunnies - 1) + 2;

	}

	public int fibonacci(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fibonacci(n - 1) + fibonacci(n - 2);

	}

}
