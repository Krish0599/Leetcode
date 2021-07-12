package Arrays;


//Solution -1 : brute force
/* T - O(n^2) ; S - O(1)
1. We need to find out the maximum difference (which will be the maximum profit) between two numbers in the given array.
2. Also, the second number (selling price) must be larger than the first one (buying price).
 */

// Solution -2 : One Pass
/* T - O(n) ; S - O(1)
1. We need to find the largest peak following the smallest valley.
2. We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and 
maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
 */
public class _121_BestTimetoBuyandSellStock {
	/*
	private static int maxProfit(int[] prices) {
		int max = 0;
		for(int i=0;i<prices.length;i++) {
			for(int j=i+1;j<prices.length;j++) {
				int profit = prices[j]-prices[i];
				max = Math.max(max, profit);
			}
		}
		return max;
	}
	*/
	
	private static int maxProfit(int[] prices) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<prices.length;i++) {
			if(prices[i] < min) {
				min = prices[i];
			}else {
				int profit = prices[i]-min;
				max = Math.max(max, profit);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		int res = maxProfit(prices);
		System.out.println(res);
	}
}

/*II problem
public int maxProfit(int[] prices) {
    int max=0;
    for(int i=1;i<prices.length;i++){
        if(prices[i] > prices[i-1]){
            max += prices[i] - prices[i-1];
        }
    }
    return max;
}
*/
