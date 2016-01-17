import java.util.*;
import java.util.HashMap;


public class GraphProblem3 {

	public int findNumberOfDisconnectedParts(HashMap<Integer, ArrayList<Integer>> adjList) {
		// Code goes here
		int Num=0;
		HashSet<Integer> visited= new HashSet<Integer>();
		
		for(int i:adjList.keySet()){
			
			
			if(!visited.contains(i)){
				
				dfs(adjList,visited,i);
				Num++;
				
				
			}
		}
		
		
		return Num;
	}

	public void dfs(HashMap<Integer, ArrayList<Integer>> adjList, HashSet<Integer> visited, int vertex){
		Stack<Integer> s=new Stack<Integer>();
		s.add(vertex);
		visited.add(vertex);

		while(s.size()>0){
			int v=s.pop();
			ArrayList<Integer> ns=adjList.get(v);
			for(int n:ns){
				if(!visited.contains(n)){
					visited.add(n);
					s.add(n);
				}			
			}			
			
		}		
	}

	public static void main(String[] args) {
		GraphProblem3 e = new GraphProblem3();
		HashMap<Integer, ArrayList<Integer>> graph1 = GraphUtilities.createRandomAdjacencyList(8, 0.2, 5);
		HashMap<Integer, ArrayList<Integer>> graph2 = GraphUtilities.createRandomAdjacencyList(8, 0.2, 4);
		HashMap<Integer, ArrayList<Integer>> graph3 = GraphUtilities.createRandomAdjacencyList(5, 0.5, 1);

		System.out.println(e.findNumberOfDisconnectedParts(graph1));
		System.out.println(e.findNumberOfDisconnectedParts(graph2));
		System.out.println(e.findNumberOfDisconnectedParts(graph3));
		// 4, 3, 1
	}

}
