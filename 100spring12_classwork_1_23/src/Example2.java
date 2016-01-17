
public class Example2 {


    public static void main(String[] args) {
        String a = new String("aaaa");
        String b = a;
        b = a.concat("t");
        
        //prints aaaa
        System.out.println(a);
        //prints aaaat
        System.out.println(b);

    }

}
