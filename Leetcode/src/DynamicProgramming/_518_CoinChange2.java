package DynamicProgramming;

//Solution-1: Brute force -> recursion choose or dont choose
/* T - O(amount* 2^n) ; S - (amount/ min of coins)
* 1. For every coin, we have option to choose or not choose
* 2. return the sum of both cases.
*/

//Solution-2: DP -> dp of total number of possibilities
/* T - O(m*n) ; S - O(m*n)
* 1. add extra row at the start so that we have a solution for one row and its not required to calculate next row manually.
* 2. So first row will be 1,0,0....
* 2. untill j < current coin, copy from previous row.
* 3. From then, it will be sum of previous row and value at col - coin amount.
*/

public class _518_CoinChange2 {
	
	// DP
	private static int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length==0)return 0;
		int[][] dp = new int[coins.length+1][amount+1];
		dp[0][0] = 1;
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(j< coins[i-1]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	
	/*
	// Brute Force - recursion
	private static int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length==0)return 0;
		return helper(coins, amount,0);
	}
	
	private static int helper(int[] coins, int amount, int index) {
		//base
		if(amount == 0)return 1;
		if(amount<0 || index == coins.length)return 0;
		//choose
		int case1 = helper(coins, amount-coins[index], index);
		//dont choose
		int case2 = helper(coins, amount, index+1);
		return case1+case2;
	}
	*/

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 5;
		int result = coinChange(coins,amount);
		System.out.println(result);
	}

}
