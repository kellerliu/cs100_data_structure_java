
public class CodingBatPrepWork {
	public int count7(int n) {

		if (n == 0) {

			return 0;
		}
		int result = count7(n / 10);
		if (n % 10 == 7)
			return result + 1;
		else
			return result;

	}

	public String endX(String str) {
		if (str.length() == 0 || str.length() == 1)
			return str;
		if (str.charAt(0) == 'x')
			return endX(str.substring(1)) + "x";
		return str.charAt(0) + endX(str.substring(1));

	}

	public String stringClean(String str) {
		if (str.length() == 0 || str.length() == 1)
			return str;
		if (str.charAt(0) == str.charAt(1))
			return stringClean(str.substring(1));
		return str.charAt(0) + stringClean(str.substring(1));
	}

}