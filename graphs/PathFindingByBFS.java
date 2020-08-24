package graphs;
import java.util.*;
import node.*;
public class PathFindingByBFS {
	
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	
	public PathFindingByBFS(ArrayList<GraphNode> nodeList){
		 this.nodeList =  nodeList;
	}
	
	public void findPath(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		
		while(!queue.isEmpty()){
			
			GraphNode currentNode = queue.poll();
			currentNode.setVisited(true);
			System.out.print("printing path for node V"+currentNode.getIndex()+" : ");
			printPath(currentNode);
			System.out.println();
			
			for(GraphNode naigbhor: currentNode.getNeighbors()){
				if(!naigbhor.isVisited()){
					queue.add(naigbhor);
					naigbhor.setVisited(true);
					naigbhor.setParent(currentNode);
				}
			}
		}
	}
	
	
	private void printPath(GraphNode node){
		if(node.getParent() != null) {
			printPath(node.getParent());
		}
		System.out.print(node.getIndex()+" ");
	}

	public void addUndirectedEdge(int i  , int j){
		GraphNode first = nodeList.get(i);
		GraphNode second  = nodeList.get(j);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}
	
}
