package DynamicProgramming.Knapsack;

public class Try {

	private static int knapsack(int[] weights, int[] prices, int capacity) {
		int n = weights.length;
		return dfs(weights, prices, capacity, n-1);
	}
	
	private static int dfs(int[] weights, int[] prices, int capacity, int index) {
		//base
		if(capacity==0 || index == 0)return 0;
		
		//logic
		
		//particular weight is more than capacity
		if(weights[index] > capacity) {
			return dfs(weights, prices, capacity, index-1);
		}else {
			//particular weight is less than capacity
			//max of choose and dont choose
			return Math.max(
					prices[index]+dfs(weights,prices, capacity-weights[index], index-1), 
					dfs(weights,prices,capacity,index-1));
		}
	}

	public static void main(String[] args) {
		int[] weights = {10, 20, 30};
		int[] prices = {60, 100, 120};
		int capacity = 50;
		int res = knapsack(weights,prices,capacity);
		System.out.println(res);
	}

}
