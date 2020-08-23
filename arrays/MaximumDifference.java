package arrays;
import java.util.*;
public class MaximumDifference {
	static int Difference(int arr[],int n){
		
		int maxdiff = arr[1] - arr[0];
		int  min_element = arr[0];
		int  i ;
		for(i =1; i<n; i++){
			if(arr[i] - min_element > maxdiff)
				maxdiff = arr[i] - min_element;
			if(min_element > arr[i])
				min_element = arr[i];
		}
		return maxdiff;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t =  in.nextInt();
		while(t-->0){
			int n =  in.nextInt();
			int[] arr =  new int[n];
			for(int i =0; i<n; i++)
				arr[i] = in.nextInt();
			System.out.println(Difference(arr, n));
		}
		in.close();
	}
}