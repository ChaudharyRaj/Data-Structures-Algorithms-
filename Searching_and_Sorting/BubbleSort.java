package Searching_and_Sorting;

public class BubbleSort {

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
		for(int i=0; i<n;i++) {
			for(int j=0; j<n-i-1; j++){
				//Swaping numbers if woring order
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
