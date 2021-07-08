package ebay;

/*
The idea is that we will store the info whether the substring from index i to index j is palindrome or not in a dp table
So the row correspond to start index of substring and column corresponds to the end index.

For eg: Consider the string babad. We know that the string aba is palindrome. The start and end indices are 1 & 3 respectively. Thus dp[1][3] = true.

Now that we have the basis set on what would be the rows and columns of the table, we know that a single character is always palindrome. Thus dp[i][i] will always be true. This means the string starting from index i and ending at index i is always true since its just a character.

We also fill the dp[i][i+1] as true if charAt(i)==charAt(i+1). This takes care of the scenario for a substring of length 2. This ensures now if the charAt(i)==charAt(j) we just have to check if the substring excluding ith and jth character was a substring.

Now because of the above approach the order of filling the dp table has to be such that we fill data for all substrings of length 1, then 2, then 3 and so on.

Thus we will have to traverse the dp table diagonally. Which makes us concerned with only the upper half of the table starting from dp[0][3].
*/

public class _5_LongestPalindromicSubstring {
	
	public static String longestPalindrome(String s) {
        if(s==null || s.length()<2)return s;
        int n = s.length();
        int a=0,b=0;
        boolean [][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(s.charAt(i) == s.charAt(j) && ((i-j < 2) || (dp[i-1][j+1] == true))){
                     if((i-j) > (b-a)){
                            b=i;
                            a=j;
                        }
                        dp[i][j] = true;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(a,b+1);
    }
	
	/*
	public static String longestPalindrome(String s) {
		if(s==null || s.length()<2)return s;
        String result="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s.substring(i,j+1)) && (j+1-i) > result.length()){
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;
	}
	
	private static boolean isPalindrome(String s){
        if(s==null || s.length()<2)return true;
        for(int i=0;i<s.length()/2;i++){
            char left = s.charAt(i);
            char right = s.charAt(s.length()-1-i);
            if(left!=right)return false;
        }
        return true;
    }
    */

	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}

}
