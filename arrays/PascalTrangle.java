package arrays;

import java.io.*;
import java.util.*;
public class PascalTrangle {
		public static void main(String[] args)throws Exception {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			List<List<Integer>> PT = new ArrayList<List<Integer>>();
		    int t = Integer.parseInt(br.readLine());
		    while(t-->0){
		       int n =  Integer.parseInt(br.readLine().trim());
		       
		       PT = trangle(n);
		       printPascal(PT);
		    }
		}
		private static List<List<Integer>> trangle(int n){
			
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			if(n == 0) return res;
			res.add(new ArrayList<>());
			res.get(0).add(1);
			
			for(int row = 1; row <n; row++) {
				List<Integer> curr =  new ArrayList<Integer>();
				curr.add(1);
				for(int col = 1; col < row; col++) {
					 curr.add(res.get(row-1).get(col-1)+res.get(row-1).get(col));
				}
				curr.add(1);
				res.add(curr);
			}
			return res;
		}
		private static void printPascal(List<List<Integer>> list){
			for(List<Integer> row : list){
				System.out.println(row.toString());
			}
		}
}
