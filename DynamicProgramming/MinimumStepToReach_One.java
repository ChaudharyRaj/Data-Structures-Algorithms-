package DynamicProgramming;

public class MinimumStepToReach_One {

	public static void main(String[] args) {
		int n = 10;
		int[] dp = new int[n+1];
		int ans  = countStep(n,dp);
		System.out.println(ans);

	}

	private static int countStep(int n,int[] dp) {
		
		if(n==1) return 0;
		int minStep=0;
		
		//using Memoization
		if(dp[n]>0)
			return dp[n];
		
		
		//Solving by option first(-1)
		int opt1 = countStep(n-1, dp);
		minStep = opt1;
		
		// Solving by option second (/2)
		if(n%2==0) {
			int otp2 = countStep(n/2, dp);
			if(otp2<minStep) minStep = otp2;
		}
		
		// Solving by thred option (/2)
		if(n%3 == 0){
			int otp3 =countStep(n/3, dp);
			if(otp3<minStep) minStep = otp3;
		}
		
		return dp[n] = 1+minStep;
	}

}
