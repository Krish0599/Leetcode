package sap;

import java.util.Arrays;

public class _1_TwoSum {
	
	//Brute Force - T- O(n^2); S - O(1)
	public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
          for(int j=i+1; j<nums.length;j++){
              if(nums[i]+nums[j] == target){
                  result[0] = i;
                  result[1] = j;
                  break;
              }
          }  
        }
        return result;
    }

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] res = twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	}
}