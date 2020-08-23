package arrays;
import java.util.*;
public class RotateArray {
	static void rotareArray(int[] arr, int k){
		int len =  arr.length;
		int[] newArray = new  int[len];
		int n = arr.length-1;
		for(int i=0; i<n; i++){
			int newindex = (i+n-k)%n;
			System.out.println(newindex);
			newArray[newindex] =  arr[i];
		}
		for(int i :newArray){
			System.out.print(i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {1,2,3,4,5,6,7};
		 int k =3;
		 System.out.println(k%arr.length);
		 //rotareArray(arr,k);
	}

}
