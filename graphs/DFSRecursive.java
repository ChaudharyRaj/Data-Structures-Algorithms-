package graphs;
import java.util.*;
import node.*;
public class DFSRecursive {
	
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	
	public DFSRecursive(ArrayList<GraphNode> nodeList){
		 this.nodeList = nodeList;
	}
	
	public void dfs(){
		for(GraphNode node : nodeList) {
			if(!node.isVisited()) {
				dfsVisit(node);
			}
		}
	}
	
	void dfsVisit(GraphNode node){
		node.setVisited(true);
		System.out.print(node.getName()+node.getIndex()+" ");
		
		for(GraphNode neighbor: node.getNeighbors()) {
			if(!neighbor.isVisited())
				dfsVisit(neighbor);
		}
	}
	
	public void addUndirectedEdge(int i, int j){
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		
	}
}
