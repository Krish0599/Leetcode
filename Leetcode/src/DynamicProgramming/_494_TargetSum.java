package DynamicProgramming;

public class _494_TargetSum {
	
	/*
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums==null || nums.length==0)return 0;
        dfs(nums, target, 0, 0);
        return count;
    }
    
    private void dfs(int[] nums, int target, int index, int currSum){
        //base
        if(index == nums.length){
            if(currSum == target)count++;
            return;
        }
        //logic
        //choose + sign
        dfs(nums,target, index+1, currSum+nums[index]);
        //choose - sign
        dfs(nums,target, index+1, currSum-nums[index]);
    }
    */
    
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int number : nums)
            sum += number;
        if (target < -sum || target > sum)
            return 0;
        int [][] dp = new int [nums.length+1][2*sum+1];
        dp[0][sum] = 1; //To shift by sum to move negative indexes to zero 
        
        for (int i=1; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                if ((j+nums[i-1] >=0) && (j+nums[i-1] < 2*sum+1)){ // positive is less than limit
                    dp[i][j] += dp[i-1][j+nums[i-1]];
                }
                if ((j-nums[i-1] >= 0) && (j-nums[i-1] < 2*sum+1)){ // negative is more than 0
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum+target];
    }

	public static void main(String[] args) {
		int[] nums= {1,1,1,1,1};
		int target = 3;
		int res = findTargetSumWays(nums, target);
		System.out.println(res);
	}

}
