package DynamicProgramming;

//Solution-1: Brute force -> recursion choose or dont choose
/* T - O(amount* 2^n) ; S - (amount/ min of coins)
 * 1. For every coin, we have option to choose or not choose
 * 2. return the min of both cases.
 * 3. To tackle condition for if only one of the case is -1, we return the other case solution.
 */

//Solution-2: DP -> dp of minimum coins required to attain amount
/* T - O(m*n) ; S - O(m*n)
 * 1. add extra row at the start so that we have a solution for one row and its not required to calculate next row manually.
 * 2. so, first row will be 0,999,999......
 * 2. untill j < current coin, copy from previous row.
 * 3. From then, it will be min of previous row, value at col - coin amount and then add 1;
 */

public class _322_CoinChange {
	// DP
	private static int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length==0)return 0;
		int[][] dp = new int[coins.length+1][amount+1];
		for(int i=1;i<dp[0].length;i++) {
			dp[0][i] = 9999;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(j<coins[i-1]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	
	/*
	// Brute Force - recursion
	private static int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length==0)return 0;
		return helper(coins, amount, 0, 0);
	}
	
	private static int helper(int[] coins, int amount, int index, int count) {
		//base
		if(amount == 0)return count;
		if(index == coins.length || amount<0)return -1;
		//choose
		int case1 = helper(coins, amount-coins[index], index, count+1);
		//dont choose
		int case2 = helper(coins, amount, index+1, count);
		
		if(case1 == -1)return case2;
		if(case2 == -1)return case1;
		return Math.min(case1, case2);
	}
	*/

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		int result = coinChange(coins,amount);
		System.out.println(result);
	}

}
