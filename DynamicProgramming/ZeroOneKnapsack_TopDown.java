package DynamicProgramming;

public class ZeroOneKnapsack_TopDown {
	
	public int knapsack(int[] profits, int[] weight, int capacity) {
		Integer[][] dp = new Integer[profits.length][capacity+1];
		return this.knapsackAux(dp,profits,weight,capacity,0);
	}
	
	private int knapsackAux(Integer[][] dp, int[]profits,  int[] weight, int capacity, int currentIndex){
		if(capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length)
			return 0;
		
		
		if(dp[currentIndex][capacity] != null)
			return dp[currentIndex][capacity];
		
		int profit =0;
		if(weight[currentIndex] <= capacity) {
			profit = profits[currentIndex] + knapsackAux(dp, profits, weight, capacity - weight[currentIndex], currentIndex+1);
		}
		int profit2  = knapsackAux(dp, profits, weight, capacity, currentIndex+1);
		dp[currentIndex][capacity] = Math.max(profit, profit2);
		return dp[currentIndex][capacity];
	}
	public static void main(String[] args) {
		ZeroOneKnapsack_TopDown ks = new ZeroOneKnapsack_TopDown();
		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		int maxProfit = ks.knapsack(profits, weights, 7);
		System.out.println(maxProfit);	
	}
}
