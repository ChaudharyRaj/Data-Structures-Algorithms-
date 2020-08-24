package graphs;
import java.util.*;

public class Graph_implemention_DFS {
	public static void printHelper(int[][] adj_mst,int sv, boolean[] visited) {
		System.out.print(sv);
		visited[sv] = true;
		int v = adj_mst.length;
		for(int i =0; i<v; i++) {
			if(visited[i] ==  false && adj_mst[sv][i] == 1)
				printHelper(adj_mst, i, visited);
		}
	}
	
	public static void print(int[][] adj_mat){
		int v = adj_mat.length;
		boolean[] visited = new boolean[v];
		for(int i =0; i<v; i++){
			if(visited[i] == false)
				printHelper(adj_mat, i, visited);
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter V");
		int v = in.nextInt();
		System.out.println("Enter E");
		int e = in.nextInt();
		int[][] adj_matrix =  new int[v][v];
		
		//implements graph
		for(int i =0; i<e; i++){
			int sv =  in.nextInt();
			int ev =  in.nextInt();
			adj_matrix[sv][ev] = 1;
			adj_matrix[ev][sv] = 1;
		}
		//travers graph uing DFS
		print(adj_matrix);
		in.close();
	}
}
