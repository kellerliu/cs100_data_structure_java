import java.util.*;

public class family_tree {
	private HashMap <String, String> paternalTree;
	private HashMap <String, String> maternalTree;
	
	family_tree()
	{
		paternalTree.put("Andy", "Bart");
		paternalTree.put("Bart", "Charles");
		paternalTree.put("Charles", "Edden");
		paternalTree.put("David", "Edden");
		
		maternalTree.put("Andy", "Betty");
		maternalTree.put("Bart", "Cathy");
		maternalTree.put("Charles", "Lily");
		maternalTree.put("Edden", "Fabbie");
	}
	
   public boolean search (String p1, String p2){
	   if (p1.equals(p2)){ 
		   return false;
	   }
	   
	   LinkedList<String> ancestorlist = new LinkedList<String>();
	   ancestorlist.push(p1);
	   
	   HashSet<String> cache = new HashSet<String>();
	   
	   while(!ancestorlist.isEmpty()){
		   String tmp = ancestorlist.pop();
		   cache.add(tmp);
		   
		   if(tmp.equals(p2))
		   {
			   return true;
		   }
		   else
		   {
//			   if(cache.contains(tmp)){
//				   continue;
//			   }
			   if (paternalTree.containsKey(tmp)){
				   String father = paternalTree.get(tmp);
				   if(!cache.contains(father))
				   {
					   ancestorlist.push(father);
				   }
				   
			   }
			   if (maternalTree.containsKey(tmp)){
				   String mather = maternalTree.get(tmp);
				   if(!cache.contains(mather))
				   {
					   ancestorlist.push(mather);
				   }
			   }
			   //cache.add(tmp);
		   }
	   }
	   
	   return false;
   }
}
