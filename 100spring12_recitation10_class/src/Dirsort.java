import java.util.*;


//new Dirsort using comparator

public class Dirsort {
	
	
	
	
	class DirComp implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			if(o1.equals(o2)) return 0;
			
			int slash1=o1.split("/").length;
			int slash2=o2.split("/").length;
			
			if(slash1!=slash2)
				return slash1-slash2;
						
			return o1.compareTo(o2);
		}
		
						
		}
	
	
	public String[] sort(String[] arr){
        String[] ret = arr;
        Arrays.sort(ret, new DirComp());
        return ret;
    }
	
	
	

}
