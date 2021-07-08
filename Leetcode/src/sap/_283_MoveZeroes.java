package sap;
import java.util.Arrays;

/* Solution - Two pointers
1. Initiate two pointers left and right to zero.
2. While traversing right pointer, if nums[right] == 0 continue.
3. If nums[right] != 0, then swap left and right pointer values and increment left pointer by 1.
*/
public class _283_MoveZeroes {
	
	public static void moveZeroes(int[] nums) {
        int left=0, right=0;
        while(right< nums.length){
            if(nums[right] != 0){
                swap(nums, left,right);
                left++;
            }
            right++;
        }
    }
    
    private static void swap(int[] nums, int left, int right){
        int temp=nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

}
