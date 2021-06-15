package DynamicProgramming;

//DP of choose or dont choose
/* T - O(max of nums, nums.length) ; S - O(max of nums*2)
* 1. As the array is not sorted and we have to remove numerical neighbors, we have to pre process the given array.
* 2. find the max value in the nums array.
* 3. create another array with the max value as length and update its locations with nums values. For eg: if the 
* value at nums[i]= 3, update new array index at 3 with the total occurances of 3's in nums *3.
* 4. create dp array with arr and 2.
* 5. update dp array with choose or not choose logic same as house robber problem
*/

public class _740_DeleteAndEarn {
	
	private static int deleteAndEarn(int[] nums) {
		if(nums==null || nums.length==0)return 0;
		int max=0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max+1];
        for(int i=0;i<nums.length;i++) {
        	int num = nums[i];
        	arr[num] += num;
        }
        int[][] dp = new int[arr.length][2];
        for(int i=1;i<dp.length;i++) {
        	dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        	dp[i][1] = dp[i-1][0]+arr[i-1];
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
	}

	public static void main(String[] args) {
		int[] nums = {2,2,3,3,3,4};
		int result = deleteAndEarn(nums);
		System.out.println(result);
	}

}
