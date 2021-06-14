package BinarySearch.LT;

//https://leetcode.com/problems/powx-n/

//Solution-1 - Linear 
/* T - O(n); S-O(1)
 1. Loop through n and multiply x with n times.
 */

//Solution-2 - Binary Search
/* T-O(logn); S - O(1)
 1. reduce n by half for every iteration.
 2. For even n, multiply twice and for odd multiply twice and multiply x
 */

public class _50_Pow_x_n {

	public static void main(String[] args) {
		double x = 2.0000;
		int n = 10;
		double result = power(x,n);
		System.out.println(result);
	}
	
	/* Solution-1
	private static double power(double x, int n) {
		double result = 1;
		for(int i=0;i<n;i++) {
			result = result * x;
		}
		return result;
	}
	*/
	
	//Solution-2
	private static double power(double x, int n) {
		//base
		if(n == 0)return 1;
		//logic
		double temp = power(x,n/2);
		if(n%2 == 0) {
			return temp*temp;
		}else {
			if(n < 0) {
				return temp*temp*(1/x);
			}else {
				return temp*temp*x;
			}
		}
	}
}
