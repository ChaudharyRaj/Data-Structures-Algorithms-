package DynamicProgramming;

public class Number_Factors_BottomUp {
	public int  waysToGetN(int n) {
		
		int[] dp = new int[n+1];
		 dp[0] = dp[1] = dp[2] = 1;
		 dp[3] =2;
		 
		 for(int i=4; i<=n; i++) {
			 dp[i] = dp[i-1] + dp[i-3] + dp[i-4];;
		 }
		return dp[n];
	}
	public static void main(String[] args) {
		Number_Factors_BottomUp en = new Number_Factors_BottomUp();
		System.out.println(en.waysToGetN(4));
		System.out.println(en.waysToGetN(5));
		System.out.println(en.waysToGetN(6));
	}
}
