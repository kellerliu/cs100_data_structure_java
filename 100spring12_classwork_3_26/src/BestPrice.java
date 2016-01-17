import java.util.PriorityQueue;


public class BestPrice {

    // you'll want to add a priority queue instance variable (PriorityQueue<Double>)
    
    public void addNewPrice(double price) {
        
    }
    
    public double buyCheapest(int numberToBuy) {
        return 0;
    }
    
    public static void main(String[] args) {
        BestPrice p = new BestPrice();
        p.addNewPrice(3);
        p.addNewPrice(9);
        p.addNewPrice(2);
        p.addNewPrice(16);
        p.addNewPrice(4.50);
        //should be (2 + 3 + 4.5 = 9.5)
        System.out.println("Buying the 3 cheapest costs " + p.buyCheapest(3));
        p.addNewPrice(2);
        p.addNewPrice(2);
        p.addNewPrice(18);
        //should be (2 + 2 + 9 = 13)
        System.out.println("Buying the 3 cheapest costs " + p.buyCheapest(3));
    }
    
}
