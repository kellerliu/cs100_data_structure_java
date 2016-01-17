import java.util.*;


public class ComplexNumber {
    private double myR; //real part
    private double myI; //imaginary part
    
    public ComplexNumber(double r, double i)
    {
        myR = r;
        myI = i;
    }
    
    public String toString() {
        return "{" + myR + " + " + myI + "i" + "}";
    }
    
    public static void main(String[] args)
    {
        System.out.println((new Integer(5)).compareTo(7));
        ComplexNumber a = new ComplexNumber(1,-37);
        System.out.println("My complex number is " + a);
        ComplexNumber equalToA = new ComplexNumber(1,-37);
        System.out.println(a.equals(equalToA));
        
        //generate some random numbers and add them to a list
        List<ComplexNumber> list = new ArrayList<ComplexNumber>();
        Random r = new Random();
        
        for(int i = 0; i < 10; i++) {
            list.add(new ComplexNumber(r.nextInt(100), r.nextInt(100)));
        }
        
        System.out.println(list);
        
        //okay, now lets sort the list
        //Collections.sort(list);
        
    }
}
