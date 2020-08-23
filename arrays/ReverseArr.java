package arrays;
import java.util.*;
public class ReverseArr {
	static void rvereseArray(int arr[] ,int start,int end){
		int temp;
		while (start < end) 
        { 
            temp = arr[start];  
            arr[start] = arr[end]; 
            arr[end] = temp; 
            start++; 
            end--; 
        }
	}
	static void printArray(int arr[],int n){ 
		for (int i = 0; i <n; i++) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	}  
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while(t-->0){
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for(int i =0; i<n; i++)
	            arr[i] = in.nextInt();
	        rvereseArray(arr,0,n-1);
	        printArray(arr,n);
	    }
	    in.close();
	}

}
