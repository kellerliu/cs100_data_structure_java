import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class GraphExample {

	public boolean[][] createRandomGraph(int nodeNum, double connectProb,
			int randomSeed) {
		boolean[][] result = new boolean[nodeNum][nodeNum];
		Random r = new Random(randomSeed);
		for (int i = 0; i < nodeNum; i++) {
			for (int j = 0; j < nodeNum; j++) {
				if (i != j) {
					if (r.nextDouble() < connectProb) {
						result[i][j] = true;
					}
				}
			}
		}
		return result;
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

	public void dumpDotFormat(boolean[][] graph) {
		System.out.println("digraph G {");
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j]) {
					System.out.println(i + "->" + j + ";");
				}
			}
		}
		System.out.println("}");
	}

	public boolean pathExists(boolean[][] g, int from, int to) {
		return pathExists(g, from, to, new HashSet<Integer>());
	}

	public boolean pathExists(boolean[][] g, int from, int to,
			Set<Integer> alreadyVisited) {
		if (alreadyVisited.contains(from))
			return false;
		// directly connected
		if (g[from][to])
			return true;

		alreadyVisited.add(from);
		for (int i = 0; i < g.length; i++) {
			if (g[from][i])
				if (pathExists(g, i, to, alreadyVisited))
					return true;
		}
		return false;
	}

	// should return true of a cycle exists on the graph
	//
	// there are some efficient and some less efficient
	// ways to do this
	public boolean hasCycle(boolean[][] g) {
		// a simple way to the do this is just check if
		// any element can visit itself
		
		 for(int i=0;i<g.length;i++){
		 for(int j=0;j<g.length;j++){
		 if(pathExists(g,i,j)&pathExists(g,j,i))
		 return true;
		 }
		 }

//		for (int i = 0; i < g.length; i++) {
//			if (pathExists(g, i, i))
//				return true;
//		}

		return false;
	}

	// should return true if the graph is strongly connected
	// a graph is strongly connected if every element
	// is reachable from every other element
	//
	// there are some efficient and some less efficient
	// ways to solve this problem
	public boolean isStronglyConnected(boolean[][] g) {
		// for(int i=0;i<g.length;i++)
		// for(int j=0;j<g.length;j++){
		// if(!pathExists(g, i, j))
		// return false;
		// }
		//
		//
		// return true;
		for (int i = 1; i < g.length; i++) {
			if (!pathExists(g, i, 0))
				return false;
			if (!pathExists(g, 0, i))
				return false;
		}
		return true;

	}

	public int lastElementInShortestPath(boolean[][] g, int from, int to) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		LinkedList<Integer> v = new LinkedList<Integer>();
		q.add(from);
		v.add(from);
		while (!q.isEmpty()) {
			int c = q.poll();
			if (g[c][to])
				return c;
			for (int i = 0; i < g.length; i++) {
				if (g[c][i]) {
					if (!v.contains(i)) {
						v.add(i);
						q.add(i);
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		GraphExample e = new GraphExample();
		boolean[][] graph1 = e.createRandomGraph(8, 0.15, 3);
		boolean[][] graph2 = e.createRandomGraph(8, 0.2, 4);
		boolean[][] graph3 = e.createRandomGraph(5, 0.5, 1);

		e.displayAdjMatrix(graph2);
		// e.dumpDotFormat(graph3);

		System.out.println(e.pathExists(graph2, 6, 6));
		System.out.println(e.hasCycle(graph1));
		System.out.println(e.hasCycle(graph2));
		System.out.println(e.hasCycle(graph3));
		
		System.out.println(e.isStronglyConnected(graph1));
		System.out.println(e.isStronglyConnected(graph2));
		System.out.println(e.isStronglyConnected(graph3));

		
		

	}

}
