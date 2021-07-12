package DynamicProgramming.Knapsack;

public class KnapsackTopDown {
	
	private static int knapsack(int[] weights, int[] prices, int capacity) {
		int n = weights.length;
		int[][] dp = new int[n+1][capacity+1];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0 || j==0)dp[i][j]=0;
			}
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(weights[i-1] > j) {
			          dp[i][j] = dp[i-1][j];
			    }else {
			    	dp[i][j] = Math.max(prices[i-1]+dp[i-1][j-weights[i-1]], dp[i-1][j]);
			    }
			}
		}
		
		return dp[n][capacity];
	}

	public static void main(String[] args) {
		int[] weights = {10, 20, 30};
		int[] prices = {60, 100, 120};
		int capacity = 50;
		int res = knapsack(weights,prices,capacity);
		System.out.println(res);
	}

}
