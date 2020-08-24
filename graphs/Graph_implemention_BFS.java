package graphs;
import java.util.*;

public class Graph_implemention_BFS {
	public static void printHelper(int[][] adj_mat, int sv, boolean[] visited) {
		int v = adj_mat.length;
		Queue<Integer> q =  new LinkedList<>();
		q.add(sv);
		visited[sv] =  true;
		while(!q.isEmpty()){
			int front = q.poll();
			System.out.print(front+"->");
			for(int i =0; i<v; i++){
				if(adj_mat[front][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] =  true;
				}
			}
		}
	}
	public static void print(int[][] adj_mat){
		int v = adj_mat.length;
		boolean[] visited = new boolean[v];
		for(int i =0 ; i<v; i++){
			if(visited[i] == false) {
				printHelper(adj_mat, i, visited);
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter No of V :");
		int v = in.nextInt();
		System.out.println("Enter No of E :");
		int e = in.nextInt();
		int[][] adj_mst = new int[v][v];
		for(int i =0; i<e; i++){
			int sv =  in.nextInt();
			int ev =  in.nextInt();
			adj_mst[sv][ev] = 1;
			adj_mst[ev][sv] = 1;
		}
		print(adj_mst);
		in.close();
	}
}
