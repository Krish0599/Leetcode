package Hashing;

import java.util.HashMap;
//HashMap based solution
/* T - O(N); S - O(N)
 * 1. split space separated s into array.
 * 2. iterate through this array and maintain two hashmaps to maintain one-one relation.
 * 3. store key value pairs in hashmap and if prev value doesnt match to current string return false. 
 */

public class _290_WordPattern {
	
	public static boolean wordPattern(String pattern, String s) {
		if(s==null || s.length()==0 || pattern==null || pattern.length()==0)return false;
		HashMap<Character,String> map1 = new HashMap<>();
		HashMap<String,Character> map2 = new HashMap<>();
		String[] strs = s.split(" ");
		for(int i=0;i<strs.length;i++) {
			String str = strs[i];
			char ch = pattern.charAt(i);
			if(!map1.containsKey(ch)) {
				map1.put(ch, str);
			}else {
				String prev = map1.get(ch);
				if(!prev.equalsIgnoreCase(str))return false;
			}
			
			if(!map2.containsKey(str)) {
				map2.put(str,ch);
			}else {
				char prev = map2.get(str);
				if(prev != ch)return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String pattern = "aaabbaaa";
		String s = "dog dog dog dog";
		boolean result = wordPattern(pattern,s);
		System.out.println(result);
	}

}
