package Hashing;

import java.util.Arrays;
import java.util.HashMap;

//Solution - 1 -> Brute Force, consider all the possible arrays
/* T - O(N^3) ; S - O(N)
 * 1. double loop through nums to get all possible arrays.
 * 2. calculate the sum of individual arrays and if sum==k,increment result.
 */

//Solution - 2 -> runnning sum and hashmap solution
/* T - O(N) ; S - O(N)
 * 1. calculate the running sum and update the map with key as sum and count of occurrences as value.If the current
 * running sum - previous running sum == k, then there is a subarray with sum=k.
 * 2. to not miss the first occurrence, first put (0,1) in map which means zero occurred 1 time.
 */

public class _560_SubarraySumEqualsK {
	
	private static int subarraySum(int[] nums, int k) {
		int result=0;
		if(nums==null || nums.length==0)return result;
		int sum=0;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, 1);
		for(int i=0;i<nums.length;i++) {
			int num = nums[i];
			sum += num;
			if(map.containsKey(sum-k)) {
				result += map.get(sum-k);
			}
			if(!map.containsKey(sum)) {
				map.put(sum, 0);
			}
			map.put(sum, map.get(sum)+1);
		}
		return result;
	}
	
	//Solution-2 -> Brute force
	/*private static int subarraySum(int[] nums, int k) {
		int result=0;
		if(nums==null || nums.length==0)return result;
		for(int i=0;i<nums.length;i++) {
			for(int j=i;j<nums.length;j++) {
				int[] temp = Arrays.copyOfRange(nums, i, j+1);
				int sum=0;
				for(int a=0;a<temp.length;a++) {
					sum += temp[a];
				}
				if(sum == k) {
					result++;
				}
			}
		}
		return result;
	}*/

	public static void main(String[] args) {
		int[] nums = {1,-1,0,0};
		int k=0;
		int result = subarraySum(nums,k);
		System.out.println(result);
	}
}
