import java.util.*;

public class Example1 {

    public static void main(String[] args) {
        DnaStrand a = new DnaStrand();
        
//        System.out.println(a.getStrandData());
//        System.out.println(a.myInt);
        
        a.setStrandData("aaaa");
        DnaStrand b = new DnaStrand(a);
        b.addBasePair("t");
        
        //prints aaaat
        System.out.println(a.getStrandData());
        System.out.println(b.getStrandData());
    }
}
