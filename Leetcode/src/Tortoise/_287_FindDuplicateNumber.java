package Tortoise;
//https://leetcode.com/problems/find-the-duplicate-number/

//Solution-1 If array is mutable -> make visited elements -ve 
/* T - O(n), S-O(1)
 1. loop through array and make the value of indexes to -ve representing visited
 2. If any value is -ve -> return the index
 */

//Solution-2 Tortoise method
/* T - O(n), S-O(1)
 1. extra iteration for removing pointer from the zeroth element of array as it cant appear again in circular loop.
 */
public class _287_FindDuplicateNumber {

	public static void main(String[] args) {
		int[] arr = {1,3,4,2,2};
		int result = findDuplicate(arr);
		System.out.println(result);
	}
	//Solution-1
	/*private static int findDuplicate(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			int num = nums[i];
			if(nums[Math.abs(num)] < 0) {
				return Math.abs(num);
			}else {
				nums[Math.abs(num)] *= -1;
			}
		}
		return -1;
	}
	*/
	
	private static int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		
		fast = nums[0];
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return fast;
	}
}
