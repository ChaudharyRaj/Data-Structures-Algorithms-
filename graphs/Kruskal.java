package graphs;
import java.util.*;
import graphUtil.*;
import mst.DisjointSet;
import node.*;
public class Kruskal {
	
	ArrayList<WeightedNode> nodeList =  new ArrayList<WeightedNode>();
	ArrayList<UndirectedEdge> edgeList =  new ArrayList<UndirectedEdge>();
	
		public Kruskal(ArrayList<WeightedNode> nodeList){
			this.nodeList = nodeList;
		}
	
	public void kruskal(){
		DisjointSet.makeSet(nodeList);
		Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>(){
			
			@Override
			public int compare(UndirectedEdge o1, UndirectedEdge o2) {
				
				return o1.getWeight() - o2.getWeight();
			}
		};
		Collections.sort(edgeList,comparator);
		int cost = 0;
		for(UndirectedEdge edge: edgeList){
			WeightedNode first = edge.getFirst();
			WeightedNode second = edge.getSecond();
			if(!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))){
				DisjointSet.union(first, second);
				cost+= edge.getWeight();
				System.out.println("Taken "+edge);
			}
		}
		System.out.println("\nTotal cost of MST: "+ cost);
	}
	
	
	
	public void addWeightedUndirectedEdge(int firstindex, int secondIndex, int weight) {
		UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstindex-1), nodeList.get(secondIndex-1), weight);
		WeightedNode first = edge.getFirst();
		WeightedNode second  = edge.getSecond();
		first.getNeigbhors().add(second);
		second.getNeigbhors().add(first);
		first.getWeightMap().put(second, weight);
		second.getWeightMap().put(first, weight);
		edgeList.add(edge);
	}
	
}
