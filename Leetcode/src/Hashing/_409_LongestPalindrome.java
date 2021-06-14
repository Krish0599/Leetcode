package Hashing;

import java.util.HashSet;
//Hashset solution
/* T - O(N) ; S - O(1)
 * 1. iterate through string and construct set with the characters
 * 2. If there is any duplicate, increase the result by 2 and remove the character from set.
 * 3. If the set.size>0-> one character at the middle of palindrome.
 */

public class _409_LongestPalindrome {
	
	public static int longestPalindrome(String s) {
		if(s==null || s.length()==0)return 0;
		int result=0;
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(!set.contains(ch)) {
				set.add(ch);
			}else {
				result +=2;
				set.remove(ch);
			}
		}
		if(set.size() > 0)return result+1;
		else return result;
	}

	public static void main(String[] args) {
		String s = "bb";
		int result = longestPalindrome(s);
		System.out.println(result);
	}
}
