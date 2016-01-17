
public class ArrayTest {
	public void makeArray()
	{
	double [] numbers =new double [50];
	for(int i=0; i<numbers.length; i++) {
	numbers [i]=20.5;
	}
	for(int i=0; i<numbers.length; i++) {
	System.out.println("The "+i+"th number is "+numbers[i]);
	
	}
	}
	public static void main (String[] args) {
	ArrayTest test= new ArrayTest();
	test.makeArray();

	}
}