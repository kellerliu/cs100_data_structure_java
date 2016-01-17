import java.util.*;


public class GalaxyTrip {
	int n;
    HashMap<Integer, ArrayList<Integer>> dep;
    
	
	public int[] possibleValues(String[] dependencies) {
		buildMap(dependencies);
		HashSet<Integer>visited=new HashSet<Integer>();
		ArrayList<Integer> visitedSize=new ArrayList<Integer>();
		ArrayList<Integer> groups=new ArrayList<Integer>();
		int index=0;
		for(int k:dep.keySet()){
			if(!visited.contains(k)){
				dfs(k,visited);	
				if(index==0){
				visitedSize.add(visited.size());
				groups.add(visited.size());
				}
				else{
					visitedSize.add(visited.size());
					groups.add(visited.size()-visitedSize.get(index-1));
					
				}
				index++;
			}
			}									
		
		
		ArrayList <Integer> sum=new ArrayList<Integer>();
				
		for(int k=0;k<groups.size();k++){
			int e=groups.get(k);
			int size=sum.size();
			
			for(int l=0;l<size;l++){			
				if(!sum.contains(e+sum.get(l)))
					sum.add(e+sum.get(l));				
			}
			if(!sum.contains(e))
			sum.add(e);			
		}

		Collections.sort(sum);
		
		int []ret=new int [sum.size()];
		for(int m=0;m<sum.size();m++){
			
			ret[m]=sum.get(m);
			//System.out.print(ret[m]+" ");
		}
		//System.out.println();
	
	return ret;
	
	}



	public void buildMap(String[] s) {
		n = s.length;
		dep = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> ds= new ArrayList<Integer>();
			String tmp = s[i];
			if (!tmp.equals("")) {
				String dArray[] = tmp.split(" ");
				for (int j = 0; j < dArray.length; j++) {
					int t = Integer.parseInt(dArray[j]);
					ds.add(t); 
				}
			}	
			dep.put(i, ds);	
					
		}
	}

	private void dfs(int vertex, HashSet<Integer> v) {
		Stack <Integer> s =new Stack<Integer>();
		s.push(vertex);
		v.add(vertex);
		while(!s.isEmpty()){
		int current=s.pop(); 
		for(int tmp:dep.get(current)){
			if(!v.contains(tmp)){
			s.add(tmp);
			v.add(tmp);
			}
		}		
		}		
	}
	
	
	
	
	public static void main(String argo[]){
		GalaxyTrip test=new GalaxyTrip();
		
		String s1[]={"1 2", "0", "0", ""};
		//Returns: {1, 3, 4 }
		test.possibleValues(s1);

		String [] s2={"1 2", "0 2", "0 1"};
		//Returns: {3}
		test.possibleValues(s2);

		String []s3={"","","",""};
		//Returns: {1, 2, 3, 4 }
		test.possibleValues(s3);

		String []s4={"4 2", "3", "0 4", "1", "0 2", "6", "5"};
		//Returns: {2, 3, 4, 5, 7 }

		test.possibleValues(s4);
		
		
		
	}

}
