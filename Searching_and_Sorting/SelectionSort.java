package Searching_and_Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,4,3,9,5,2,10,7,6,8};
		sort(arr);
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	private static void sort(int[] arr) {
		int n = arr.length;
		for(int i= 0; i<n; i++){
			int min = i;
			System.out.println(min);
			for(int j =i+1; j<n; j++) { // finding minimum element from unsorted arry
				
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			
			if(min != i){
				// if found minimum elemnt the swap them with unsorted first positon
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp; 
			}
			
		}
	}

}
