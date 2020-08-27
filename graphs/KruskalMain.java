package graphs;

import java.util.*;
import node.*;

public class KruskalMain {

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		
		for(int i=0;i<5;i++) {
			nodeList.add(new WeightedNode(""+(char)(65+i)));
		}
		Kruskal graph = new Kruskal(nodeList);
		
		//add weighted edges following graph in graph.docx
		
		//Add A<-> B , weight 10
		graph.addWeightedUndirectedEdge(1,2,10);
		
		//Add A<-> C , weight 20
		graph.addWeightedUndirectedEdge(1,3,20);
		
		graph.addWeightedUndirectedEdge(2,3,40);
		
		graph.addWeightedUndirectedEdge(2,4,5);
		
		graph.addWeightedUndirectedEdge(3,4,15);
		graph.addWeightedUndirectedEdge(3,5,6);
		
		graph.addWeightedUndirectedEdge(4,5,8);
		
		
		//run kruskal on graph
		System.out.println("Running Kruskal's Algo on the graph: ");
		graph.kruskal();
	}

}
