package graphs;
import java.util.*;
import node.*;

public class TopologicalSort {

	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	public TopologicalSort(ArrayList<GraphNode> nodeList){
		this.nodeList = nodeList;
	}
	
	public void topologicalSort(){
		Stack<GraphNode> stack = new Stack<GraphNode>();
		for(GraphNode node : nodeList) {
			if(!node.isVisited()) {
				topologicalvisit(node, stack);
			}
		}
		while(!stack.isEmpty()) {
			GraphNode vretex = stack.pop();
			System.out.println(vretex.getName()+vretex.getIndex()+" ");
		}
	}
	
	void topologicalvisit(GraphNode node, Stack<GraphNode> stack){
		
		for(GraphNode naigbhor :node.getNeighbors()) {
			if(!naigbhor.isVisited()) {
				topologicalvisit(naigbhor,stack);
			}
		}
		stack.push(node);
		node.setVisited(true);
	}
	
	public void addDirectedEdge(int i, int j){
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
	}
}
