package graphs;

import java.util.*;
import node.*;

public class FloydWarshall {
	
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	
	public FloydWarshall(ArrayList<WeightedNode> nodeList){
		this.nodeList = nodeList;
	}
	
	public void floydWarshall() {
		
		int size = nodeList.size();
		int[][] V = new int[size][size];
		
		for(int i=0; i < size; i++){
			WeightedNode first = nodeList.get(i);
			for(int j=0; j<size; j++){
				WeightedNode second = nodeList.get(j);
				if( i == j)
					V[i][j] = 0; 
				else if(first.getWeightMap().containsKey(second)){
					V[i][j] = first.getWeightMap().get(second);
				}else {
					V[i][j] = Integer.MAX_VALUE/10;
				}
			}
		}//end of loop
		
		//Floyd Warshall's Algorithm
		for(int k=0; k < nodeList.size();k++){
			for(int i =0; i<nodeList.size(); i++) {
				for(int j =0; j<nodeList.size(); j++){
					if(V[i][j] > V[i][k] + V[k][j]) {
						V[i][j] = V[i][k] + V[k][j];
					}
				}
			}
		}//end of loop
		
		// Print table of node with minimum distance and shortest path from each source
		for(int i =0; i<size; i++){
			System.out.println("Printing Distance list for node "+nodeList.get(i)+": ");
			for(int j=0; j<size; j++){
				System.out.print(V[i][j]+" ");
			}
			System.out.println();
		}
	}// end of method
	
	
	
	public void addWeightedEdge(int i, int j, int d){
		
		WeightedNode first = nodeList.get(i-1);
		WeightedNode second = nodeList.get(j-1);
		first.getNeigbhors().add(second);
		first.getWeightMap().put(second, d);
		
	}
}
