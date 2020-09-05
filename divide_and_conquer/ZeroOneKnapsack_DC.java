package divide_and_conquer;

public class ZeroOneKnapsack_DC {

	public int knapsack(int[] profits, int[] weights, int capacity) {
		return this.kanpsackAux(profits, weights, capacity, 0);
	}

	private int kanpsackAux(int[] profits, int [] weights, int capacity, int currntIndex) {
		if(capacity <= 0 || currntIndex < 0 || currntIndex >= weights.length)
			return 0;
		int profit1 = 0;
		if(weights[currntIndex] <= capacity){
			profit1 = profits[currntIndex] + kanpsackAux(profits, weights, capacity - weights[currntIndex] , currntIndex+1);
		}
		int profit2 = kanpsackAux(profits, weights, capacity, currntIndex+1);
		return Math.max(profit1, profit2);
	}
	
	public static void main(String[] args) {
		ZeroOneKnapsack_DC ks = new ZeroOneKnapsack_DC();
		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		int maxProfit = ks.knapsack(profits, weights, 7);
		System.out.println(maxProfit);

	}
}
