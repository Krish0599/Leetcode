package ebay;

import java.util.Arrays;

//Solution-1: Brute force -> recursion choose or dont choose
/* T - O(2^n) ; S - (log n)
 * 1. consider two cases: 0 - n-1 houses and 1 - n houses and return max of them.
 */

//Solution-2: DP of amount collected
/* T - O(m*2) ; S - O(m*2)
* consider two cases: [0,n-1] houses and [1,n] houses and return max of them.
* 1. dp first row -> 0, nums[0]
* 2. if house not choosen, it should be max of previous rows as the amount is to be maximised.
* 3. if house choose, it will be previous not choosen + current house amount.
*/

public class _213_HouseRobberII {
	
	//DP
	public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0]; 
        return Math.max(helper(Arrays.copyOfRange(nums, 0,n-1),0,0), helper(Arrays.copyOfRange(nums, 1,n),0,0));
	}
	
	private static int helper(int[] nums, int index, int sum){
		if(nums==null || nums.length==0)return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;// intialzing dummy row
        dp[0][1] = nums[0];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0){
                	//not choose
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j+1]);// taking max between the two values as when not choosing the current value, we need to consider them max sum till now
                }else{
                	//choose
                    dp[i][j] = dp[i-1][j-1]+nums[i];//if choosing then take the value from not choosing the prveious value and add the value of choosing the current one
                }
            }
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);// returning max from the last row which has two cases of choosing and not choosing the last value
	}
	
	//Brute force -> recursion
	/*
	 public static int rob(int[] nums) {
	        int n = nums.length;
	        if(n==1)return nums[0]; 
	        return Math.max(helper(Arrays.copyOfRange(nums, 0,n-1),0,0), helper(Arrays.copyOfRange(nums, 1,n),0,0));
	 }
	 
	 private static int helper(int[] nums, int index, int sum){
	         //base
	         if(index>= nums.length)return sum;
	         //logic
	         //choose
	         int case1 = helper(nums, index+2,sum+nums[index]);
	         //dont choose
	         int case2 = helper(nums, index+1, sum);
	         return Math.max(case1,case2);
	 }
	 */

	public static void main(String[] args) {
		int[] nums = {2,3,2};
		int result = rob(nums);
		System.out.println(result);
	}

}
