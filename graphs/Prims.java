package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

import node.WeightedNode;

public class Prims {
	
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	
	//Constructor
	public Prims(ArrayList<WeightedNode> nodeList){
		this.nodeList = nodeList;
	}
	
	// Prim's algorithm from source node
	public void prims(WeightedNode node){
		
		for(int counter = 0; counter<nodeList.size(); counter++){
			nodeList.get(counter).setDistance(Integer.MAX_VALUE);
		}
		node.setDistance(0);// Setting '0' distance for Source Vertex
		
		System.out.println("I am waiting");
		try {Thread.sleep(10 * 100);}catch (InterruptedException e) {e.printStackTrace();}
		
		PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		queue.addAll(nodeList);
		
		while(!queue.isEmpty()){
			
			WeightedNode currentNode = queue.remove();//If vertex is not processed, only then enter in if-else 
				for (WeightedNode neighbor : currentNode.getNeigbhors()){
					if (queue.contains(neighbor)) {//If vertex is not processed, only then enter in if-else 
						//If known weight of this ‘adjacent vertex’ is more than current edge, 
						//then update ‘adjacent vertex’s’ distance and parent
						if (neighbor.getDistance() > currentNode.getWeightMap().get(neighbor)) {
							neighbor.setDistance(currentNode.getWeightMap().get(neighbor));
							neighbor.setParent(currentNode);
							queue.remove(neighbor); // Refresh the priority queue
							queue.add(neighbor);
						}//end of if-else
					}//end of if-else
				}//end of for loop
		}//end of loop
		
		int cost = 0;
		// print table of node with minimum distance and shortest path from source
		for(WeightedNode nodeToCheck : nodeList){
			System.out.println("Node "+ nodeToCheck+" key: "+nodeToCheck.getDistance()+" Parent: "+nodeToCheck.getParent());
			cost = cost + nodeToCheck.getDistance();
		}
		System.out.println("\nTotal cost of MST: "+cost);
	}
	
	// add a weighted undirected edge between two nodes
	public void addWeightedUndirectedEdge(int i, int j, int d){
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j-1);
		first.getNeigbhors().add(second);
		second.getNeigbhors().add(first);
		first.getWeightMap().put(second,d);
		second.getWeightMap().put(first, d);
	}
}
