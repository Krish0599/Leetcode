package Hashing;

import java.util.Arrays;
import java.util.HashMap;

//Solution - 1 -> Brute Force, consider all the possible arrays
/* T - O(N^3) ; S - O(N)
* 1. double loop through nums to get all possible arrays.
* 2. calculate the sum of individual arrays and increment by 1 if num == 1 or by -1 if num==0.
* 3. if sum == 0; update result;
*/

//Solution - 2 -> runnning sum and hashmap solution
/* T - O(N) ; S - O(N)
* 1. calculate the running sum and update the map with key as sum and count of occurrences as value.If the current
* running sum == previous running sum , then there is a subarray with equal 0's and 1's.
* 2. to not miss the first occurrence, first put (0,-1) in map which means sum is zero at -1 location.
*/

public class _525_ContiguousArray {
	
	private static int findMaxLength(int[] nums) {
		int result=0;
		if(nums==null || nums.length==0)return result;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			int num = nums[i];
			sum = num == 0 ? sum-1 : sum +1;
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}else {
				int prev = map.get(sum);
				result = Math.max(result, (i-prev));
			}
		}
		return result;
	}
	
	/*private static int findMaxLength(int[] nums) {
		int result=0;
		if(nums==null || nums.length==0)return result;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				int[] temp = Arrays.copyOfRange(nums, i, j+1);
				int sum=0;
				for(int k=0;k<temp.length;k++) {
					int num = temp[k];
					sum = num == 0 ? sum-1: sum+1;
				}
				if(sum == 0)result = Math.max(result, (j-i+1));
			}
		}
		return result;
	}*/

	public static void main(String[] args) {
		int[] nums = {1,0,1,0,1,1,1,1,0,0,1,0,1};
		int result = findMaxLength(nums);
		System.out.println(result);
	}

}
