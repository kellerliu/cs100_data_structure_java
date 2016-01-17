public class GraphProblem1 {

	public boolean isGraphTwoColorable(boolean[][] graph) {
		int[] colors = new int[graph.length];

		// Code goes here...
		for (int i = 0; i < graph.length; i++) {
			if (colors[i] == 0) {//save extra checking
				if (!color(graph, colors, i, 1, 2))
					return false;
			}
		}
		return true;
	}

	public boolean color(boolean[][] graph, int[] colors, int vertex,
			int color1, int color2) {

		// You'll want this helper method
//     method1
//		colors[vertex] = color1;
//		for (int i = 0; i < graph.length; i++) {
//			if (graph[vertex][i]) {
//				if (colors[i] == color1)
//					return false;
//				if (colors[i] == 0) {
//					if (!color(graph, colors, i, color2, color1))
//						return false;
//				}
//			}
//		}
//		return true;
		
// method2
		if(colors[vertex]==color1) return true;
		if(colors[vertex]==color2) return false;
		
		colors[vertex]=color1;
		for(int i=0;i<graph.length;i++){			
			if(graph[vertex][i]){
				if(!color(graph,colors,i,color2, color1))
					return false;
			}			
		}		
		return true;		
	}

	public static void main(String[] args) {
		GraphProblem1 e = new GraphProblem1();
		boolean[][] graph1 = GraphUtilities.createRandomUndirectedGraph(8,
				0.25, 8);
		boolean[][] graph2 = GraphUtilities.createRandomUndirectedGraph(8, 0.4,
				4);
		boolean[][] graph3 = GraphUtilities.createRandomUndirectedGraph(5, 0.5,
				1);

		System.out.println(e.isGraphTwoColorable(graph1));
		System.out.println(e.isGraphTwoColorable(graph2));
		System.out.println(e.isGraphTwoColorable(graph3));
		// false, false, true
	}

}
