package sap;

public class _121_BestTimetoBuyandSellStock {
	
	/* Brute force
	public static int maxProfit(int[] prices) {
        int result=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                result = Math.max(result, prices[j]-prices[i]);
            }
        }
        return result;
    }
    */
	
	// T - O(n) ; S- O(1)
	  public static int maxProfit(int[] prices) {
	      int max=0;
          int min = Integer.MAX_VALUE;
          for(int i=0;i<prices.length;i++){
        	  if(prices[i] < min){
        		  min = prices[i];
        	  }else{
                max = Math.max(max, prices[i]-min);
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
