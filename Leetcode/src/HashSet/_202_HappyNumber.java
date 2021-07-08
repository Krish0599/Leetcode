package HashSet;

import java.util.HashSet;

/*Two solutions - Iterative and Recursive; T - O(logn) ; S - O(n)
Based on our exploration, we'd expect continually following links to end in one of three ways.
1.It eventually gets to 1
2.It eventually gets stuck in a cycle.

Part 1 can be done by using the division and modulus operators to repeatedly take digits off the number until none remain, 
and then squaring each removed digit and adding them together. 

Part 2 can be done using a HashSet. Each time we generate the next number in the chain, we check if it's already in our HashSet.
If its already present then its stuck in a cycle.
 */

public class _202_HappyNumber {
	
	//Recursive
	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<>();
		while(n!=1 && !set.contains(n)) {
			set.add(n);
			n = getSum(n);
		}
		if(n==1)return true;
		return false;
	}
	private static int getSum(int n) {
		if(n==0)return 0;
		int digit = n%10;
		return (digit*digit) + getSum(n/10);
	}
	
	//Iterative
	private static boolean isHappy1(int n) {
		HashSet<Integer> set = new HashSet<>();
		while(n>0) {
			set.add(n);
			int sum=0;
			while(n>0) {
				int digit = n%10;
				sum += digit*digit;
				n=n/10;
			}
			n=sum;
			if(n==1)return true;
			else if(set.contains(sum))return false;
		}
		return false;
	}

	public static void main(String[] args) {
		int n=19;
		System.out.println(isHappy(n));
	}
}
