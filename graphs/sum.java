package graphs;
import java.util.*;
public class sum {
	 public static void addEdge(Vector<Integer> adj[], int u, int v){
	        adj[u].addElement((v));
	    }
	    
	    public static int findSum(Vector<Integer> adj[],int v){
	        int sum =0;
	        for(int u =0; u<v; u++){
	            sum += adj[u].size();
	        }
	        return sum;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		   int t = in.nextInt();
		   while(t-->0){
		       int V = in.nextInt();
		       int e = in.nextInt();
		       Vector<Integer> adj[] = new Vector[V]; 
		       for(int i =0; i<adj.length; i++){
		           adj[i] = new Vector<>();
		       }
		            
		       for(int i =0; i<e; i++){
		           int u =  in.nextInt();
		           int v =  in.nextInt();
		           addEdge(adj, u, v);
		       }
		       System.out.println(findSum(adj,V));
		  }
		   in.close();
	}

}
