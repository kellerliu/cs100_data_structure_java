import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class AncestorsSol {

    public boolean isFemaleAncestor(HashMap<String,String> motherMap, String child, String possibleAncestor) {
        String current = child;
        while(motherMap.containsKey(current)) {
            String mother = motherMap.get(current);
            if(mother.equals(possibleAncestor)) {
                return true;
            }
            current = mother;
        }
        return false;
    }
    
    public boolean isFemaleAncestorRecursive(HashMap<String,String> motherMap, String child, String possibleAncestor) {
        if(!motherMap.containsKey(child))
            return false;
        String mother = motherMap.get(child);
        if(mother.equals(possibleAncestor))
            return true;
        return isFemaleAncestorRecursive(motherMap,mother,possibleAncestor);
    }

    public boolean isAncestorRecursive(HashMap<String,String> motherMap,
                                       HashMap<String,String> fatherMap, 
                                       String child, 
                                       String possibleAncestor) {
        if(child == null)
            return false;
        
        //there's a hint below
        if(possibleAncestor.equals(motherMap.get(child)))
            return true;
        if(possibleAncestor.equals(fatherMap.get(child)))
            return true;
        
        if(isAncestorRecursive(motherMap,fatherMap,motherMap.get(child),possibleAncestor))
            return true;
            
        if(isAncestorRecursive(motherMap,fatherMap,fatherMap.get(child),possibleAncestor))
            return true;
            
        return false;
    }

    public boolean isAncestorNonRecursive(HashMap<String,String> motherMap,
            HashMap<String,String> fatherMap, 
            String child, 
            String possibleAncestor) {
        LinkedList<String> folksToCheck = new LinkedList<String>();
        if(motherMap.containsKey(child))
            folksToCheck.add(motherMap.get(child));
        if(fatherMap.containsKey(child))
            folksToCheck.add(fatherMap.get(child));
        while(!folksToCheck.isEmpty()) {
            String personToCheck = folksToCheck.remove(0);// it removes the first element and return to the String personToCheck
            if(personToCheck.equals(possibleAncestor))
                return true;
            if(motherMap.containsKey(personToCheck))
                folksToCheck.add(motherMap.get(personToCheck));
            if(fatherMap.containsKey(personToCheck))
                folksToCheck.add(fatherMap.get(personToCheck));            
        }
        return false;
    }
    
    public static void main(String[] args) {
        AncestorsSol a = new AncestorsSol();
        HashMap<String,String> mothers = new HashMap<String,String>();
        mothers.put("Steve","Sharon");
        mothers.put("Jane","Sharon");
        mothers.put("Tom","Mary");
        mothers.put("Sharon","Lisa");
        mothers.put("Lisa","Eve");
        mothers.put("Abel","Eve");
        
        HashMap<String,String> fathers = new HashMap<String,String>();
        fathers.put("Steve","Tom");
        fathers.put("Jane","Tom");
        fathers.put("Sharon","Paul");
        fathers.put("Paul","Jeb");
        fathers.put("Tom","Frank");
        fathers.put("Lisa","Adam");
        fathers.put("Abel","Adam");
        
        //should print true
        System.out.println(a.isFemaleAncestor(mothers, "Steve", "Eve"));
        
        //should print true
        System.out.println(a.isAncestorNonRecursive(mothers, fathers, "Steve", "Eve"));
        //should print true
        System.out.println(a.isAncestorNonRecursive(mothers, fathers, "Steve", "Paul"));
        //should print false
        System.out.println(a.isAncestorNonRecursive(mothers, fathers, "Steve", "Abel"));

        
    }
}

/* HINT RECURSIVE VERSION
 * 
 * If the possible ancestor is a father or a mother, then return true
 * Otherwise the possible ancestor must either be an ancestor of the father
 * or an ancestor of the mother
 */
