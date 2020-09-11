package DynamicProgramming;

public class ZeroOneKnapsack_BottomUp {
	public int solveKnapsack(int[] profits, int[] weights, int capacity){
		if(capacity <= 0 || profits.length == 0 || weights.length != profits.length)
			return 0;
		int numberofRow = profits.length;
		int[][] dp = new int[numberofRow][capacity+1];
		for(int i =0; i<numberofRow; i++)
			dp[i][0] =0;
		
		for(int i =0; i<=capacity; i++)
			dp[numberofRow-1][i] = 0;
		
		for(int row = numberofRow -2; row >= 0; row--){
			for(int column = 1; column <= capacity; column++) {
				int profit1 = 0; int profit2 =0;
				if(weights[row] <= column){
					profit1 = profits[row] + dp[row+1][column - weights[row]];
				}
				profit2 = dp[row][column];
				dp[row][column] = Math.max(profit1, profit2);
			}
		}
		return dp[0][capacity];
	}//end of method
	public static void main(String[] args) {
		ZeroOneKnapsack_BottomUp ks = new ZeroOneKnapsack_BottomUp();
		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		System.out.println(ks.solveKnapsack(profits, weights, 7));
	}

}
