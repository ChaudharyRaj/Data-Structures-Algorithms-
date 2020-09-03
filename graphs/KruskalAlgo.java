package graphs;
import java.util.*;

class Edge implements Comparable<Edge>{
	int src = 0;
	int des = 0;
	int weight = 0;
	 @Override
	public int compareTo(Edge o) {
		
		return this.weight - o.weight;
	}	
}

public class KruskalAlgo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		int e = in.nextInt();
		Edge inp[]  =  new Edge[e];
		
		for(int i =0; i<e; i++) {
			inp[i] =  new Edge();
			inp[i].src = in.nextInt();
			inp[i].des = in.nextInt();
		}
		
		kruskal(inp,e,v);

	}
	
	private static void kruskal(Edge[] inp, int e, int v){
		 Arrays.sort(inp);
		 Edge output[] = new Edge[v-1];
		 int parent[] = new int[v];
		 int k =0;
		 for(int i=0; i<v; i++)
			 parent[i] = i;
		 for(int i=0; i<e; i++){
			 if(k == v-1) break;
			 Edge currEdge = inp[i];
			 int srcParent = find(currEdge.src, parent);
			 int descParent = find(currEdge.des, parent);
			 if(srcParent != descParent) {
				 output[k] = currEdge;
				 k++;
				 parent[srcParent] = descParent;
			 } 
		 }
		 for(int i =0; i< output.length; i++) {
			 System.out.println(output[i].src+" -> "+output[i].des+"-> "+output[i].weight);
		 }
	}
	
	private static int find(int v, int[] parent){
		if(parent[v] == v)
			return v;
		return find(parent[v], parent);
	}
}
