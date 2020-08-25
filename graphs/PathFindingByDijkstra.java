package graphs;
import java.util.*;
import node.*;
public class PathFindingByDijkstra{
	
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	
	public PathFindingByDijkstra(ArrayList<WeightedNode> nodeList){
		this.nodeList = nodeList;
	}
	
	public void dijkstra(WeightedNode node){
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		node.setDistance(0); //This will make sure that we start from this vertex in priority queue as distance is min
		queue.addAll(nodeList);
		while(!queue.isEmpty()) {
			WeightedNode presentNode = queue.remove(); //remove node with minimum distance from queue
			for(WeightedNode neighbor: presentNode.getNeigbhors()) { //for each neighbor
				if(queue.contains(neighbor)) { //if neighbor is not visited
					// if 'known distance' of neighbor is greater than new path then, 
					// update 'distance' of neighbor 
					// and also new parent as presentNode
					if(neighbor.getDistance() > (presentNode.getDistance()+presentNode.getWeightMap().get(neighbor))) {
						neighbor.setDistance((presentNode.getDistance()+presentNode.getWeightMap().get(neighbor)));
						//Refresh the Priority Queue
						neighbor.setParent(presentNode);
						queue.remove(neighbor);
						queue.add(neighbor);
					}//end of if block
				}//end of if block
			}//end of for loop
		}//end of while loop
		
		
		//print table of node with minimum distance and shortest path from source
		for(WeightedNode nodeToCheck: nodeList) {
			System.out.print("Node "+nodeToCheck+", distance: "+nodeToCheck.getDistance()+", Path: ");
			printPath(nodeToCheck);
			System.out.println();
		}
	}//end of method
	
	private void printPath(WeightedNode node){
		if(node.getParent() != null){
			printPath(node.getParent());
			System.out.print("->"+node);
		}else
			System.out.println(node);
	}//end of method
	
	// add a weighted directed edge between two nodes
	public void addWeightedEdge(int i, int j, int d){
		WeightedNode first = nodeList.get(i-1);
		WeightedNode second =  nodeList.get(j-1);
		first.getNeigbhors().add(second);
		first.getWeightMap().put(second,d);
	}
}
