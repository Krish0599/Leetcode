package DynamicProgramming;

// It cant be connected components as it will be difficult to restrict the traversal to form a square.

//Solution-1 -> Brute force
/* T - O(m^2*n^2) ; S - O(1)
 * 1. double loop over the matrix and if char == 1 and set flag to true.
 * 2. consider it as a square matrix of length 1 and increment diagonally with curr pointer.
 * 3. As we increment over digaonally, traverse columns and rows to check if every char is 1.
 * 4. If not set flag to false and if its a square matrix increment curr to check for bigger square.
 * 5. keep a global variable to keep count of max length of square and update accordingly and finally return (length)^2.
 */

//DP
/* T - O(mn) ; S - O(mn)
 * 1. create a dp with m+1 and n+1 size
 * 2. If a square can be formed, the max length at that point is min of its top, top diagonal and left value +1.
 * 3. keep a global max and update it whenever dp value is changing.
 */

public class _221_MaximalSquare {
	
	//DP
	private static int maximalSquare(char[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0)return 0;
		int m = matrix.length;int n = matrix[0].length;
		int[][] dp = new int[m+1][n+1];
		int max = 0;
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(matrix[i-1][j-1] == '1') {
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max*max;
	}
	
	/*
	// Brute force
	private static int maximalSquare(char[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0)return 0;
		int m = matrix.length;int n = matrix[0].length;
		int max=0;
		boolean flag = false;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j] == '1') {
					int curr=1;
					flag = true;
					while(i+curr < m && j+curr < n && flag) {
						//column
						for(int k=i+curr;k>=i;k--) {
							if(matrix[k][j+curr] != '1') flag = false;//break if needed
						}
						//row
						for(int k=j+curr;k>=j;k--) {
							if(matrix[i+curr][k] != '1') flag = false;//break if needed
						}
						if(flag)curr++;
					}
					max=Math.max(max, curr);
				}
			}
		}
		return max*max;
	}
	*/

	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//		char[][] matrix = {{'0','1'},{'1','0'}};
		int result = maximalSquare(matrix);
		System.out.println(result);
	}

}