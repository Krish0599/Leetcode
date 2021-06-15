package DynamicProgramming;

import java.util.HashSet;
	//Brute force
	/*T - O(2^n) ; S - O(n)
	 * 1. convert wordDict to set for O(1) lookup.
	 * 2. At every step we can choose to split or not split
	 * 3. if set contains prefix string and recursion of string suffix, then return true.
	 * 4. as the string keeps decreasing, base case is s.len ==0 then return true.
	 */

	//DP
	/*
	Thought Process:
	    There are repeated permutations on how to use the string. So it's a dp problem.
	    Understanding on how to create a dp boolean array lies the basis of the solution in here.
	    
	    T.C -> O(N3) - 2 nested loops and substring
	    S.C -> O(N) - where N is the length of the string
	*/

public class _139_WordBreak {
	
	private static boolean wordBreak(String s, String[] wordDict) {
		//edge case
        if(s.length() == 0) 
            return true;
        HashSet<String> set = new HashSet<>(); // to store the dictionary
        for(String word: wordDict) {
			set.add(word);
		}
        boolean dp[] = new boolean[s.length()+1]; // dp array
        dp[0] = true; // set the first value to true as a null string prior to that is always valid

        for(int i=0;i<dp.length;i++) // iterate on dp array 
        {
            for(int j=0;j<i;j++) //move j till i
            {
                if(dp[j] && set.contains(s.substring(j,i))) // if  the string till j has been found and set contains the rest of string
                {
                    dp[i] = true; // set the value for the position as true i.e prior to that, we have found words in the dictionary
                }
            // if value not found j goes till i 
            }
        }

        return dp[dp.length-1]; // return value at last index
		
	}
	/*
	static HashSet<String> set;
	private static boolean wordBreak(String s, String[] wordDict) {
		if(s==null || s.length()==0)return false;
		set = new HashSet<>();
		for(String word: wordDict) {
			set.add(word);
		}
		return helper(s);
	}
	
	private static boolean helper(String s) {
		//base
		if(s.length() == 0)return true;
		//logic
		for(int i=0;i<=s.length();i++) {
			if(set.contains(s.substring(0, i)) && helper(s.substring(i)))return true;
		}
		return false;
	}
	*/

	public static void main(String[] args) {
		String s = "leetcode";
		String[] wordDict = {"leet","code"};
		boolean result = wordBreak(s, wordDict);
		System.out.println(result);
	}

}
