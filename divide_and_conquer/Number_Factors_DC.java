package divide_and_conquer;

import java.util.Scanner;

public class Number_Factors_DC {
	public int waysToGetN(int n) {
		if(n  == 0|| n == 1 || n ==2) {
			return 1;
		}else if(n == 3)
			return 2;
		
		int subtract1 = waysToGetN(n-1);
		int subtract2 = waysToGetN(n-2);
		int subtract3 = waysToGetN(n-3);
		return subtract1+subtract2+subtract3;
	}
	
	public static void main(String[] args) {
		
		Scanner in =  new Scanner(System.in);
		Number_Factors_DC Nf = new Number_Factors_DC();
		int n = in.nextInt();
		System.out.println(Nf.waysToGetN(n));
		in.close();
	}

}
