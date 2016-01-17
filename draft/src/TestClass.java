

public class TestClass {

	public void myFunction(String foo)
	{
		System.out.println("In a very cool function " + foo);
	}
	
	public static void main(String[] args)
	{
		System.out.println("Hello class");
		TestClass myVariable = new TestClass();
		String foo = "seven";
		
		myVariable.myFunction("qqq");
		
		
	}
	
}
  