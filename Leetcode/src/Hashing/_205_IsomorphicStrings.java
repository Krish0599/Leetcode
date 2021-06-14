package Hashing;

import java.util.HashMap;

// https://leetcode.com/problems/isomorphic-strings/

//Solution: HashMap based
/* T - O(N) , S - O(N)
 * 1. As we have to maintain one-one relation b/n two strings, we have to maintain two hashmaps.
 * 2. first hashmap maps s characters to t characters and same for second hashmap.
 * 3. if the map value doesn't equate the current char, then return false.
 */

public class _205_IsomorphicStrings {
	
	public static boolean isIsomorphic(String s, String t) {
		if(s==null || s.length()==0 || t==null || t.length()==0 || s.length() != t.length())return false;
		HashMap<Character,Character> map1 = new HashMap<>();
		HashMap<Character,Character> map2 = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			
			if(!map1.containsKey(sChar)) {
				map1.put(sChar, tChar);
			}else {
				char prev = map1.get(sChar);
				if(prev != tChar)return false;
			}
			
			if(!map2.containsKey(tChar)) {
				map2.put(tChar, sChar);
			}else {
				char prev = map2.get(tChar);
				if(prev != sChar)return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "paper";
		String t = "title";
		boolean result = isIsomorphic(s,t);
		System.out.println(result);
	}

}
