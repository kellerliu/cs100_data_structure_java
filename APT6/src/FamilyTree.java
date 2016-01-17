import java.util.*;

public class FamilyTree {
 
	public int firstBad(String[] data){
		HashMap <String, ArrayList<String>> parMap = new HashMap<String,ArrayList <String>>();
		HashMap <String, String> genderMap = new HashMap<String,String>();

		
		for(int i=0;i<data.length;i++){
			
			String[]info=data[i].split(" ");
			String child=info[0];
			String par=info[1];
			
			if (par.equals("m")||par.equals("f")){
				if(!genderMap.containsKey(child)){
					genderMap.put(child,par);
				}
				
				else if (!(genderMap.get(child)).equals(par)){
				return i;// one can't have two genders
				}
				
			}
			
			else{			
  				if(!parMap.containsKey(child)){
  					ArrayList<String> newpar= new ArrayList <String>();
  					newpar.add(par);
					parMap.put(child,newpar);		
  				}
  				
  				else if (!parMap.get(child).contains(par)) {
  					parMap.get(child).add(par); 					
  					if(parMap.get(child).size()>2)
  						return i; // one can't have more than 2 parents
  				}				
  				
			}
			
			for (String kid:parMap.keySet()){
				if (parMap.get(kid).contains(par)&&parMap.get(kid).size()==2){
					int index = parMap.get(kid).indexOf(par);
					if(genderMap.containsKey(par)&&genderMap.containsKey(parMap.get(kid).get(1-index)))
						if(genderMap.get(par).equals(genderMap.get(parMap.get(kid).get(1-index))))
						return i;// one can not form parents with another person known to be of same gender
				}
			}
			
			for (String kid:parMap.keySet()){
				if (parMap.get(kid).contains(child)&&parMap.get(kid).size()==2){// the child is actually a parent, with known partner
					int index = parMap.get(kid).indexOf(child);
					if(genderMap.containsKey(child)&&genderMap.containsKey(parMap.get(kid).get(1-index)))// the genders of "this child" and "partner" is known
						if(genderMap.get(child).equals(genderMap.get(parMap.get(kid).get(1-index))))
						return i;// the parents of a kid cannot have same gender
				}
			}
			
  				LinkedList <String> pList= new LinkedList <String>();
  				pList.add(child);
  				while(!pList.isEmpty()){
  					String tmp=pList.remove();
  					if(parMap.containsKey(tmp)){
  						for(String s:parMap.get(tmp) ){
  							pList.add(s);
  							if(s.equals(child))
  								return i;// one can't be descendant of one's own
  						}
   					}
  				} 				
			}			
    	  return -1;// everything fits
    	  
}

//	public static void main(String[]args){
//		FamilyTree f=new FamilyTree();
//		String[] data1 = {"BOB JOHN","BOB MARY","MARY JOHN","JOHN f","MARY f","AL f"};
//		System.out.println(f.firstBad(data1));
//		
//		String[] data2 = {"BOB JOHN","JOHN f","MARY f","BOB MARY","MARY JOHN","AL f"};
//		System.out.println(f.firstBad(data2));
//		
//}

}
