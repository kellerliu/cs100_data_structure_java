import java.util.*;

public class graphProbSample {
	// problem 1:makeAllPathsDirect adds edges to the graph so that
	// any node reachable from the starting node is directly connected to the
	// starting node.
	public void makeAllPathsDirect(HashMap<Integer, ArrayList<Integer>> g,
			int start) {
		Stack<Integer> s = new Stack<Integer>();
		HashSet<Integer> v = new HashSet<Integer>();
		v.add(start);
		s.addAll(g.get(start));
		while (!s.isEmpty()) {
			int c = s.pop();
			if (!g.get(start).contains(c))
				g.get(start).add(c);
			if (!v.contains(c)) {
				v.add(c);
				s.addAll(g.get(c));
			}
		}
	}

	// problem2: returns the shortest path from the start to end that includes a
	// gas station
	// - the function should return the id of the 2nd to last node on the path.
	public int shortestPathWithGasStation(boolean[][] g, int start, int end) {

		LinkedList<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> v = new HashSet <Integer>();
		q.add(-start);
		v.add(-start);

		while (!q.isEmpty()) {
			int c=q.poll();
			if(c<0){
				if((-c)%5==0){
					for(int i=0;i<g.length;i++){						
						if(g[-c][i] && (!v.contains(i)) ){
						q.add(i);
						v.add(i);
						}
					}
				}
				
				else{					
					for(int i=0;i<g.length;i++){						
						if(g[-c][i] && (!v.contains(-i)) ){
						q.add(-i);
						v.add(-i);
						}
					}					
				}				
			}
			
			else{				
				if(g[c][end])
				return c;
				
				for(int i=0;i<g.length;i++){					
					if(g[c][i] && (!v.contains(i)) ){
					q.add(i);
					v.add(i);
					}
				}								
			}
		}
		return -1;
	}

	// problem 3, should return boolean instead of void?
	// boolean[][]g instead of int[][]g?
	public boolean isLastElementOnShorestPath(boolean[][] g, int start,
			int end, int lastElement) {
		if (g[lastElement][end]) {
			LinkedList<Integer> q = new LinkedList<Integer>();
			HashMap<Integer, Integer> v = new HashMap<Integer, Integer>();
			boolean find = false;
			int depth=-1;
			q.add(start);
			v.put(start, 0);
			while (!q.isEmpty()) {
				int c = q.poll();
				if (g[c][end]) {
					if (c == lastElement) {
						if (!find)
							return true;
						if(find && v.get(c)==depth)
							return true;
						if(find && v.get(c)>depth)
							return false;
					}
					else if (!find){						
							depth=v.get(c);						
						find=true;
					}
					else {
						if(v.get(c)>depth)
							return false;
					}					
				}
				for (int i = 0; i < g.length; i++) {
					if (g[c][i]) {
						if (!v.containsKey(i)) {
							q.add(i);
							v.put(i, v.get(c) + 1);
						}
					}
				}
			}
		}
		return false;
	}

	public static void main(String argo[]) {
		graphProbSample test = new graphProbSample();

	}

}
