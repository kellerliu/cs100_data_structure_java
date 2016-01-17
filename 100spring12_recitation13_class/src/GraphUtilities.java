import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class GraphUtilities {
	public static boolean[][] createRandomDirectedGraph(int nodeNum, double connectProb, int randomSeed) {
		boolean[][] result = new boolean[nodeNum][nodeNum];
		Random r = new Random(randomSeed);
		for(int i = 0; i < nodeNum; i++) {
			for(int j = 0; j < nodeNum; j++) {
				if(i != j) {
					if(r.nextDouble() < connectProb) {
						result[i][j] = true;
					}
				}
			}
		}
		return result;
	}

	public static boolean[][] createRandomUndirectedGraph(int nodeNum, double connectProb, int randomSeed) {
		boolean[][] result = new boolean[nodeNum][nodeNum];
		Random r = new Random(randomSeed);
		for(int i = 0; i < nodeNum; i++) {
			for(int j = i+1; j < nodeNum; j++) {
				if(r.nextDouble() < connectProb) {
					result[i][j] = true;
					result[j][i] = true;
				}
			}
		}
		return result;
	}

	public static HashMap<Integer, ArrayList<Integer>> createRandomAdjacencyList(int nodeNum, double connectProb, int randomSeed) {
		boolean[][] temp = createRandomUndirectedGraph(nodeNum, connectProb, randomSeed);
		HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
		//dumpDotFormatUndirected(temp);
		for(int i = 0; i < nodeNum; i++) {

			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j < nodeNum; j++) {
				if(temp[i][j]) {
					list.add(j);
				}
			}
			adjList.put(i, list);
		}
		return adjList;
	}

	public static void displayAdjMatrix(boolean[][] graph) {
		System.out.print("  ");
		for(int i = 0; i < graph.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 0; i < graph.length; i++) {
			System.out.print(i + " ");
			for(int j = 0; j < graph.length; j++) {
				if(graph[i][j]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}

			}
			System.out.println();
		}
	}

	public static void dumpDotFormatDirected(boolean[][] graph) {
		System.out.println("digraph G {");
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				if(graph[i][j]) {
					System.out.println(i + "->" + j + ";");
				}
			}
		}
		System.out.println("}");
	}

	public static void dumpDotFormatUndirected(boolean[][] graph) {
		System.out.println("graph G {");
		for(int i = 0; i < graph.length; i++) {
			for(int j = i+1; j < graph.length; j++) {
				if(graph[i][j]) {
					System.out.println(i + "--" + j + ";");
				}
			}
		}
		System.out.println("}");
	}


}
