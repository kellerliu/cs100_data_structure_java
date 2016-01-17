import java.util.*;
public class B extends A implements myInterface{

	public void doSuperBending(){
		System.out.println("SuperBending");
	} 
	
	//public static void main(String[]arg){
		//B robot=new B();
		//robot.doBending();
		//robot.doSuperBending();
	//}
	
	public void doBending(){
		doSuperBending();//this is overriding
	}
	public static void main(String[]arg){
		B robot=new B();
		robot.doBending();
		robot.doSuperBending();
		robot.beeping();
	}
	
	public void beeping() {
		//  Auto-generated method stub
		System.out.println("beep-beep");
	}
	
	 
	

	AbstractList <String> list1=new ArrayList<String>();
	List <String> list2=new ArrayList<String>(); //always use the most general one, it let you use


	
	
}
