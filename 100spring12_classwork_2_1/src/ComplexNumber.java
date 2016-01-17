import java.util.*;

public class ComplexNumber implements Comparable<ComplexNumber> {
	private double myR; // real part
	private double myI; // imaginary part

	public ComplexNumber(double r, double i) {
		myR = r;
		myI = i;
	}

	public String toString() {
		return "{" + myR + " + " + myI + "i" + "}";

	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplexNumber other = (ComplexNumber) obj;
		if (other.myR == (myR) && other.myI == (myI))// for double, use==, not
														// equal.

		{
			return true;
		}
		return false;
	}

	public int compareTo(ComplexNumber other) {
		if (myI * myI + myR * myR == (other.myI) * (other.myI) + (other.myR)
				* (other.myR))
			return 0;

		else {
			if (myI * myI + myR * myR < (other.myI) * (other.myI) + (other.myR)
					* (other.myR))
				return 1;
			else
				return -1;
		}
	}

	public static void main(String[] args) {
		System.out.println((new Integer(5)).compareTo(7));// 0 equal, 1>, -1<
		ComplexNumber a = new ComplexNumber(1, -37);
		System.out.println("My complex number is " + a);
		ComplexNumber equalToA = new ComplexNumber(1, -37);
		System.out.println(a.equals(equalToA));

		// generate some random numbers and add them to a list
		List<ComplexNumber> list = new ArrayList<ComplexNumber>();
		Random r = new Random();

		for (int i = 0; i < 10; i++) {
			list.add(new ComplexNumber(r.nextInt(100), r.nextInt(100)));
		}

		System.out.println(list);

		// okay, now lets sort the list
		Collections.sort(list);
		System.out.println(list);
		
		for (int i = 0; i < 10; i++) {
			System.out.println(""+list.get(i).myI*list.get(i).myI+list.get(i).myR*list.get(i).myR);
		}
	}
}
