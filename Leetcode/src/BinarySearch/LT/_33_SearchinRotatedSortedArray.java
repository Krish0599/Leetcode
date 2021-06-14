package BinarySearch.LT;
//https://leetcode.com/problems/search-in-rotated-sorted-array/

//Solution - BinarySearch
/* T - O(logn), S- O(1)
 1. At any point,one part of array will be always sorted.
 2. Focus on sorted side and manipulate l,h accordingly.
 */
public class _33_SearchinRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2};
		int target = 0;
		int result = binarySearch(arr, target);
		System.out.println(result);
	}
	
	private static int binarySearch(int[] arr, int target) {
		int l=0,h=arr.length-1;
		while(h>=l) {
			int m=l+(h-l)/2;
			if(arr[m] == target) {
				return m;
			}else if(arr[l] <= arr[m]) {
				if(arr[l] <= target && target<=arr[m]) {
					h=m-1;
				}else {
					l=m+1;
				}
			}else {
				if(arr[m] <= target && target <= arr[h]) {
					l=m+1;
				}else {
					h=m-1;
				}
			}
		}
		return -1;
	}
}
