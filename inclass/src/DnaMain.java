import java.util.HashSet;
import java.util.*;


public class DnaMain {
	public static void main(String[] args){
		DNAstrand a= new DNAstrand();
		DNAstrand b= new DNAstrand();
		//String funString=new String();
		//funString.
		
		ArrayList<String> list =new ArrayList<String>();
		ArrayList<DNAstrand> list2 =new ArrayList<DNAstrand>();
		list2.add(a);
		list2.add(b);
		list2.remove(a);
		
		boolean hasAnA =list2.contains(a);

		for(DNAstrand current:list2){
			
		}
		
		HashSet<String> set =new HashSet<String>();
		set.add("qqq");
		set.add("b");
		set.add("qqq");
		System.out.println(set.size());
		//should print out 2.
		
		
		HashMap<String, DNAstrand> map =new HashMap<String, DNAstrand>();
		map.put("qqq",b);
		map.put("qqq",a);
		map.get("qqq");
		
		
		
		
		
		a.setStrandData("cat");
		b.setStrandData("tttttt");
		b.addBasePair("a");
		
		
		System.out.println(a.setStrandData());
		System.out.println(b.setStrandData());
		System.out.println(b.is3rdBasePairCytosine());	
	
		
		
			
		
	
}
}
