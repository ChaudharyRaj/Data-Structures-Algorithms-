package graphs;

import java.util.*;
import node.*;;

public class GraphMainClass {

	public static void main(String[] args) {
		
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
		
		for(int i =1; i<11; i++){
			nodeList.add(new GraphNode("V", i));
		}
		TopologicalSort graph = new TopologicalSort(nodeList);
		
		graph.addDirectedEdge(1,2);
		graph.addDirectedEdge(1,4);
		graph.addDirectedEdge(2,3);
		graph.addDirectedEdge(2,5);
		graph.addDirectedEdge(3,6);
		graph.addDirectedEdge(3,10);
		graph.addDirectedEdge(4,7);
		graph.addDirectedEdge(5,8);
		graph.addDirectedEdge(6,9);
		graph.addDirectedEdge(7,8);
		graph.addDirectedEdge(8,9);
		graph.addDirectedEdge(9,10);
		System.out.println("Sorting");
		graph.topologicalSort();
		System.out.println("Sorted");
	}

}
