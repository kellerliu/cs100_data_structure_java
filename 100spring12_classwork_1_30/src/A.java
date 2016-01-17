
public class A implements myInterface{
	public void doBending(){
		System.out.println("Bending");
	} 
	
	public static void main(String[]arg){
		A robot=new A();
		robot.doBending();
		robot.beeping();
	}

	@Override
	public void beeping() {
		//  Auto-generated method stub
		System.out.println("beep-beep-blabla");

		
	}
	
}


