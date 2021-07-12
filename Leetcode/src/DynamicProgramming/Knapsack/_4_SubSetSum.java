package DynamicProgramming.Knapsack;

public class _4_SubSetSum {
	
	/*
	private static boolean isSubsetSum(int[] nums, int sum) {
		return dfs(nums, sum, 0);
	}
	
	private static boolean dfs(int[] nums, int sum, int index) {
		//base
		if(sum == 0)return true;
		if(index == nums.length)return false;
		
		
		//logic
		//choose || dont choose
		return dfs(nums, sum-nums[index], index+1) || dfs(nums, sum, index+1);
	}
	*/
	private static boolean isSubsetSum(int[] nums, int sum) {
		boolean[][] dp = new boolean[nums.length+1][sum+1];
		
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i] = false;
		}
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = true;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				
				if(nums[i-1] <= j) {
					dp[i][j] = dp[i][j-nums[i-1]] || dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

	public static void main(String[] args) {
		int[] nums = {3, 34, 4, 12, 5, 2};
		int sum = 30;
		boolean res = isSubsetSum(nums, sum);
		System.out.println(res);
	}
}
