package DynamicProgramming;
import java.io.*;
import java.util.*;

public class MinCoins {

	public static void main(String[] args)  throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    int coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
	    while(t-->0){
	        int n = Integer.parseInt(br.readLine());
	        int[] dp = new int[n+1];
	        Arrays.fill(dp,-1);
	        dp[0] = 0;
	        int ans = minCoins(n,coins,dp);
	        System.out.println(ans);
	        for(int x : dp){
	               System.out.print(x+" ");
	        }
	        System.out.println();	
	    }
	}
	    public static int minCoins(int n, int[] coins, int[] dp){
		     
		     if(n == 0) return 0;
		     int ans = Integer.MAX_VALUE;
		     for(int i = 0; i<coins.length; i++){
		         if(n-coins[i] >= 0){
		             int subAnswer = 0;
		             if(dp[n - coins[i]] != -1){
		                 subAnswer = dp[n- coins[i]];
		             }else{
		                 subAnswer = minCoins(n-coins[i],coins,dp);
		             }
		             if(subAnswer != Integer.MAX_VALUE && subAnswer +1 <ans){
		                 ans = subAnswer+1;
		             }
		         }
		     }
		     return dp[n] = ans;
	  }
}
