package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//HashMap prime product based solution
/* T - O(Nk) k->avg length of words; S - O(N)
 * 1. Iterate through the array and find prime product for every word
 * 2. prepare the map with prime product as keys and their respective list of strings corresponding to that product.
 * 3. return hasmap values.
 */
public class _49_GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String [] strs){
		List<List<String>> result = new ArrayList<>();
		if(strs==null || strs.length==0)return result;
		HashMap<Long, List<String>> map = new HashMap<>();
		for(int i=0;i<strs.length;i++) {
			String str = strs[i];
			long val = primeProduct(str);
			if(!map.containsKey(val)) {
				map.put(val, new ArrayList<>());
			}
			map.get(val).add(str);
		}
		return new ArrayList<>(map.values());
	}
	
	public static long primeProduct(String str) {
		if(str==null || str.length()==0)return 0;
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,67,71,73,79,83,89,97,101,103};
		long product = 1;
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			product *= primes[ch-'a'];
		}
		return product;
	}

	public static void main(String[] args) {
		String [] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result = groupAnagrams(strs);
		System.out.println(result);
	}
}
