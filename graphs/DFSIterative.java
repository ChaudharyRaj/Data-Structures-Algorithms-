package graphs;
import java.util.*;
import node.*;
public class DFSIterative {
	
	ArrayList<GraphNode> nodeList =  new ArrayList<GraphNode>();
	
	public DFSIterative(ArrayList<GraphNode> nodeList){
		this.nodeList  =  nodeList;
	}
	
	public void DFS(){
		for(GraphNode node: nodeList){
			if(!node.isVisited())
				dfaVisited(node);
		}
	}
	
	void dfaVisited(GraphNode node){
		Stack<GraphNode> st = new Stack<GraphNode>();
		st.push(node);
		node.setVisited(true);
		while(!st.isEmpty()){
			GraphNode currentNode = st.pop();
			System.out.print(currentNode.getName()+currentNode.getIndex()+" ");
			for(GraphNode neighbor: currentNode.getNeighbors()) {
				if(!neighbor.isVisited()) {
					st.push(neighbor);
					neighbor.setVisited(true);
				}
			}
		}
	}
	
	public void addUndirectedEdge(int i , int j){

		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}
}
