package DynamicProgramming;

public class MinimumStepstoReach_One {

	public static void main(String[] args) {
		int n = 10;
		int[] dp = new int[n+1];
		int ans = countStep(n,dp);
		System.out.println(ans);

	}

	private static int countStep(int n, int[] dp) {
		if(n == 0) return 1;
		dp[1] = 0;
		for(int i = 2; i<=n;i++){
			int min = dp[i-1];
			if(i%2 == 0) {
				if(min > dp[i/2])
					min = dp[i/2];
			}
			if(i%3 == 0) {
				if(min > dp[i/3])
					min = dp[i/3];
			}
			dp[i] = 1+min;
		}
		return dp[n];
	}
}
