package graphs;
import java.util.*;
import node.*;
public class PathFindingByBellmanFord{
	
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	
	public PathFindingByBellmanFord(ArrayList<WeightedNode> nodeList){
		this.nodeList = nodeList;
		for(WeightedNode aNode : nodeList){
			aNode.setDistance(Integer.MAX_VALUE/10);
		}
	}
	
	public void bellmanFord(WeightedNode sourseNode){
		sourseNode.setDistance(0);
		
		for(int i =0; i<nodeList.size(); i++){
			for(WeightedNode currentNode : nodeList){// for each vertex
				for(WeightedNode neighbor : currentNode.getNeigbhors()){// for each  neibhor
					// if distance of neighbor is greater than tentative new path then
					// update distance of neighbor with new parent as presentNode
					if(neighbor.getDistance()> (currentNode.getDistance()+currentNode.getWeightMap().get(neighbor))) {
						neighbor.setDistance((currentNode.getDistance()+currentNode.getWeightMap().get(neighbor)));
						neighbor.setParent(currentNode);
					}
				}//end of inner loop
			}//end of mid loop
		}//end of loop
		
		System.out.println("Cheking for nagative Cycle....");
		
		for(WeightedNode currentNode : nodeList){
			for(WeightedNode neighbor : currentNode.getNeigbhors()){
				if(neighbor.getDistance() > (currentNode.getDistance()+currentNode.getWeightMap().get(neighbor))){
					System.out.println("Nagative cycle found: \n");
					System.out.println("Vertex Name :"+neighbor.getName());
					System.out.println("Old distance :"+neighbor.getDistance());
					int newDestance = currentNode.getDistance()+currentNode.getWeightMap().get(neighbor);
					System.out.println("New distance: "+ newDestance);
					return;
				}
			}
		}//enf of loop
		System.out.println("Nagative Cycle not found !");
		
		System.out.println("\n\n Printing Paths now:");
		for(WeightedNode nodeTocheck : nodeList) {
			if(nodeTocheck.getDistance() != Integer.MAX_VALUE/10) {
				System.out.println("Node "+nodeTocheck+", Distance: "+nodeTocheck.getDistance()+", Path");
				pathPrint(nodeTocheck);
			}else {
				System.out.println("No path for node"+ nodeTocheck);
			}
			System.out.println();
		}//end of loop
	}//end of method
	
	
	private void pathPrint(WeightedNode node){
		
		if(node.getParent()!= null){
			pathPrint(node.getParent());
			System.out.print("->"+node);
		}else
			System.out.print(node);
	}
	public void  addWeightedEdge(int i, int j, int d){
		WeightedNode first = nodeList.get(i-1);
		WeightedNode second = nodeList.get(j-1);
		first.getNeigbhors().add(second);
		first.getWeightMap().put(second,d);
	}
}
