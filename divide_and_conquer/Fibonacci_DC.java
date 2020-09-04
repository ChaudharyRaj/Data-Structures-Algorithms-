package divide_and_conquer;

import java.util.Scanner;

public class Fibonacci_DC {
	public int calculateFibonachi(int n){
		if(n<1) {
			System.out.println("Please Enther Psitive Integer Number");
			return Integer.MIN_VALUE;
		}else if(n == 1) {
			return 0;
		}else if(n == 2) {
			return 1;
		}else {
			return calculateFibonachi(n-1)+calculateFibonachi(n-2);
		}
	}// end of method
	public static void main(String[] args) {
		Fibonacci_DC fb  =  new Fibonacci_DC();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter N: ");
		int n =  in.nextInt();
		System.out.println("Fibonachi Serise of "+n+" -->"+fb.calculateFibonachi(n));
		in.close();
	}

}
