package Searching_and_Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,4,3,9,5,2,10,7,6,8};
		sort(arr);
		for(int i : arr){
			System.out.print(i);
		}
	}
	
	private static void sort(int[] arr) {
		int n = arr.length;
		
		for(int i =1; i<n; i++){
			
			int curr = arr[i];
			int j = i;
			
			while(j>0 && arr[j-1] > curr) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = curr;
		}
	}

}
