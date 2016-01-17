import java.util.HashMap;
import java.util.Map;

public class UtilMapHash implements IMapper{

    private HashMap<String,Integer> myMap;
    
    public UtilMapHash(){
        myMap = new HashMap<String,Integer>();
    }
    
    public boolean containsKey(String key) {
        return myMap.containsKey(key);
    }

    public int get(String key) {
        return myMap.get(key);
    }

    public void printAll() {
        for(Map.Entry<String,Integer> entry : myMap.entrySet()){
            System.out.printf("%s\t%d\n",entry.getKey(),entry.getValue());
        }
    }

    public void put(String key, int value) {
        myMap.put(key,value);
    }
    
    public int size(){
        return myMap.size();
    }

}
