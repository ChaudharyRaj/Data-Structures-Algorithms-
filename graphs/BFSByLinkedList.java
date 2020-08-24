package graphs;
import java.util.*;
import node.*;
public class BFSByLinkedList {
	
	ArrayList<GraphNode> nodeList =   new ArrayList<GraphNode>();
	//Constructor
	public BFSByLinkedList(ArrayList<GraphNode> nodeList){
		this.nodeList = nodeList;
	}
	
	public void bfs(){
		for(GraphNode node: nodeList) {
			if(!node.isVisited())
				bfsVisit(node);
		}
	}
	
	void bfsVisit(GraphNode node) {
		Queue<GraphNode> queue = new  LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode currentNode = queue.remove();
			currentNode.setVisited(true);
			System.out.print(currentNode.getName()+currentNode.getIndex()+" ");
			for(GraphNode neibhor: currentNode.getNeighbors()){
				if(!neibhor.isVisited()){
					queue.add(neibhor);
					neibhor.setVisited(true);
				}
			}
		}	
	}
	
	//Add an undirected edge between two edge 
	public void addUndirectedEdge(int i, int j){
		GraphNode first = nodeList.get(i-1);
		GraphNode secound = nodeList.get(j-1);
		first.getNeighbors().add(secound);
		secound.getNeighbors().add(first);
	}
}
