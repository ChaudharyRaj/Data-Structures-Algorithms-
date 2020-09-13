package DynamicProgramming;

public class MinCostToReachLastCellI_in2DArray_TD {

	public static void main(String[] args){
		int[][] array =
			{
				{1,3,1},{ 1,5,1},{4,2,1},
			};
		MinCostToReachLastCellI_in2DArray_TD mctrlc = new MinCostToReachLastCellI_in2DArray_TD();
		System.out.print("The minimum cost is " + mctrlc.findMinCost(array, array.length - 1, array[0].length - 1));
	}

	private int findMinCost(int[][] array, int row, int col){
		int[][] dp = new int[row+1][col+1]; // use array for memoization 
		return findMinCost_aux(array,row,col,dp);
	}

	private int findMinCost_aux(int[][] array, int row, int col, int[][] dp){
		
		if(row == -1 || col == -1)
			return 0;
		if(row == 0 && col == 0)
			return array[0][0];
		
		if(dp[row][col] == 0){ // memoization
            int minCost1 = findMinCost_aux(array,row-1,col,dp);
            int minCost2 = findMinCost_aux(array,row,col-1,dp);
        
            int minCost = Math.min(minCost1,minCost2);
            int currentCost = array[row][col];
            dp[row][col] = currentCost+minCost;
        }
		return dp[row][col];
	}
}
