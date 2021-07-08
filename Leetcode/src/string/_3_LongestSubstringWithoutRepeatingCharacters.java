package string;
import java.util.HashMap;
import java.util.HashSet;

//Solution-1 - Brute force
/* T-O(n3) ; S - O(n)
1. We can consider all substrings one by one and check for each substring whether it contains all unique characters or not.
2. Whether a substring contains all unique characters or not can be checked in linear time by scanning it from left to right and keeping a map of visited characters.
*/

//Solution-2 - Sliding Window
/* T-O(n) ; S- O(n)
 * 1. Start with two pointers left and right with a hashmap to store last occurrences of characters.
 * 2. Slide right till the character is seen in hashmap, If seen move the start pointer to position after the previous occurrence.
 * 3. Update the last seen index in hashmap and update the length.
 */

public class _3_LongestSubstringWithoutRepeatingCharacters {
	
	/* Solution -1
	public static int lengthOfLongestSubstring(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(checkUniqueCharacters(s,i,j)){
                    result = Math.max(result, (j-i+1));
                }
            }
        }
        return result;
    }
    
    private static boolean checkUniqueCharacters(String s, int i, int j){
        HashSet<Character> set = new HashSet<>();
        for(int k=i;k<=j;k++){
            char ch = s.charAt(k);
            if(set.contains(ch))return false;
            set.add(ch);
        }
        return true;
    } 
    */
	
	//Solution-2
	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
		int result=0;
		int left=0, right=0;
		while(right<s.length()) {
			char ch = s.charAt(right);
			if(map.containsKey(ch)) {
				int prev = map.get(ch);
				left = Math.max(left, prev);
			}
			map.put(ch, right+1);
			result = Math.max(result, (right-left+1));
			right++;
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int len = lengthOfLongestSubstring(str);
		System.out.println(len);
	}
}
