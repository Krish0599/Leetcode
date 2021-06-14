package BinarySearch.main;

/* Given sorted array and a target, find nearest floor value to the target. If no value return "".
eg: 
1) arr = [10,20,30,40,50], target = 20 -> output : 20

2) arr = [10,20,30,40,50], target = 15 -> output : 10

3) arr = [10,20,30,40,50], target = 0 -> output : ""
*/

//Solution-1 Brute Force - Linear Search
/* Time- O(n); Space - O(1)
 1. loop through the array, and initialize index to -1;
 2. if arr[i] > target, then break from the loop.
 3. else update index to i.
 4. If index = -1 then return "", else return arr[index];
 */

//Solution-2 Binary Search
/* Time- O(logn); space - O(1)
 1. find mid,if arr[m] == target, return m;
 2. else if arr[m] > target, then h = m-1;
 3. else l = m+1 and update index = m;
 4. If index = -1 then return "", else return arr[index];
 */
public class FindFloorValue {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int target = 15;
		int result = findFloor(arr, target);
		System.out.println(result);
	}
	
	//Linear Search
	/* private static int findFloor(int[] arr, int target) {
		int index = -1;
		for(int i=0; i<arr.length;i++) {
			if(arr[i] > target) {
				break;
			}else {
				index = i;
			}
		}
		if(index == -1)return -1;
		else return arr[index];
	}
	*/
	
	//Binary Search
	private static int findFloor(int[] arr, int target) {
		int l=0, h=arr.length-1, index=-1;
		while(h>=l) {
			int m = l+(h-l)/2;
			if(arr[m] == target) {
				return arr[m];
			}else if(arr[m] > target) {
				h = m-1;
			}else {
				index= m;
				l=m+1;
			}
		}
		if(index == -1)return -1;
		else return arr[index];
	}
}
