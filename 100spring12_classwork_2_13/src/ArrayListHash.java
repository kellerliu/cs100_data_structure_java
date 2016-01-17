import java.util.*;

public class ArrayListHash implements IMapper {
   
    private static int SIZE = 1000000;
    
    private class Combo {
        int value;
        String key;
        public Combo(String key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private ArrayList<ArrayList<Combo>> myTable;
    private int mySize;

    
    public ArrayListHash(){
        myTable = new ArrayList<ArrayList<Combo>>(SIZE);
        for(int k=0; k < SIZE; k++){
            myTable.add(null);
        }
        mySize = 0;
    }
    
    private int getHash(String key){
        return Math.abs(key.hashCode()) % SIZE;
    }
    
    private Combo getCombo(String key){
        int bucketIndex = getHash(key);
        ArrayList<Combo> list = myTable.get(bucketIndex);
        if (list == null){
            return null;
        }
        else {
            for(Combo c : list){
                if (c.key.equals(key)){
                   return c;
                }
            }
            return null;
        } 
    }
    
    public boolean containsKey(String key){
        return getCombo(key) != null;
    }
    
    public int get(String key){
        return getCombo(key).value;
    }
   
    public void put(String key, int value){
        Combo c = getCombo(key);
        if (c != null){
            c.value = value;
        }
        else {
            int bucketIndex = getHash(key);
            ArrayList<Combo> list = myTable.get(bucketIndex);
            if (list == null){
                list = new ArrayList<Combo>();
                myTable.set(bucketIndex, list);
            }
            list.add(new Combo(key,value));
            mySize++;
        }
    }
   
    public void printAll(){
        for(ArrayList<Combo> list : myTable){
            if (list == null) continue;
            for(Combo c : list){
                System.out.println(c.key+"\t"+c.value);
            }
        }
    }
    
    public int size(){
        return mySize;
    }
   
}
