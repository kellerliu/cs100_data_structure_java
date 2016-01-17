import java.util.*;


public class GraphProblem2 {
	
	public int sumNodesInShortestPath(boolean[][] graph, int from, int to) {
		// This is the solution to lastElementInShortestPath from Wednesday
		// We'll use it as a starting point
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, Integer> previous=new HashMap<Integer, Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        
        q.add(from);
        visited.add(from);
        while(!q.isEmpty()) {
            int current = q.remove();
            if(graph[current][to]){
            	int sum=to;
            	while(current!=from){           		
            		sum+=current;
            		current=previous.get(current);            		
            	}
                return sum+from;
            }
            
            for(int i = 0; i < graph.length; i++) {
                if(graph[current][i]) {
                    if(!visited.contains(i)) {
                        visited.add(i);
                        q.add(i);                        
                        previous.put(i, current);
                        
                    }
                }
            }
        }
        return -1;
	}
	public void displayAdjMatrix(boolean[][] graph) {
		System.out.print("  ");
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}

			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		GraphProblem2 e = new GraphProblem2();
		boolean[][] graph1 = GraphUtilities.createRandomUndirectedGraph(8, 0.1, 3);
		boolean[][] graph2 = GraphUtilities.createRandomUndirectedGraph(10, 0.3, 4);
		boolean[][] graph3 = GraphUtilities.createRandomUndirectedGraph(8, 0.3, 1);

		e.displayAdjMatrix(graph1);

		System.out.println(e.sumNodesInShortestPath(graph1, 0, 6));
		e.displayAdjMatrix(graph2);

		System.out.println(e.sumNodesInShortestPath(graph2, 0, 4));
		e.displayAdjMatrix(graph3);

		System.out.println(e.sumNodesInShortestPath(graph3, 7, 3));
		// -1, 11, 21
	}

}
