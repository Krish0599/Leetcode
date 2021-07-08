package DynamicProgramming;

//Solution-1: Brute force -> recursion choose or dont choose
/* T - O(2^n) ; S - (log n)
* 1. For every house, we have option to choose or not choose
* 2. return the max of both cases.
*/

//Solution-2: DP of amount collected
/* T - O(n) ; S - O(n)
* 1. dp first row -> 0, nums[0]
* 2. if house not choosen, it should be max of previous rows as the amount is to be maximised.
* 3. if house choose, it will be previous not choosen + current house amount.
*/

//Solution-3 No extra space
/* T- O(n) ; S - O(1)
 * 1. Have two variables exclusive and inclusive and initiate inclusive to first house amount.
 * 2. loop through every house and excl and incl.
 * 3. return max of exclusive and inclusive.
 */

public class _198_HouseRobber {
	
	//with no extra space
	private static int rob(int[] nums) {
		int prev_skip=0;
		int prev_taken=0;

	    for(int i=0; i<nums.length; i++){
	        int temp = prev_skip; // storing prev value when not choosed
	        prev_skip = Math.max(prev_skip, prev_taken); // when not choosing current value we have to take max from the prev skip and take
	        prev_taken = temp+nums[i]; // when choosing add prev value when prev skipped  and add current value
	    }
	    return Math.max(prev_skip,prev_taken);
	}
	
	/*
	//DP
	private static int rob(int[] nums) {
		if(nums==null || nums.length==0)return 0;
		int[][] dp = new int[nums.length][2];
		dp[0][1] = nums[0];
		for(int i=1;i<dp.length;i++) {
			dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
			dp[i][1] = dp[i-1][0]+nums[i-1];
		}
		return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
	}
	*/
	
	
	/*
	//Brute force -> recursion
	private static int rob(int[] nums) {
		if(nums==null || nums.length==0)return 0;
		return helper(nums, 0,0);
	}
	
	private static int helper(int[] nums, int index, int amount) {
		//base
		if(index>=nums.length)return amount;
		//choose
		int case1 = helper(nums, index+2,amount+nums[index]);
		//dont choose
		int case2 = helper(nums, index+1, amount);
		return Math.max(case1, case2);
	}
	*/

	public static void main(String[] args) {
		int[] nums = {2,3,2};
		int result = rob(nums);
		System.out.println(result);
	}

}
