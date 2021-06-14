package DynamicProgramming;

public class _256_PaintHouse {
	
	private static int minCost(int[][] costs) {
		if(costs==null || costs.length==0 || costs[0].length==0)return 0;
		for(int i=1;i<costs.length;i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		}
		return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
	}
	
	//Brute Force
	/*
	private static int minCost(int[][] costs) {
		if(costs==null || costs.length==0 || costs[0].length==0)return 0;
		int case1 = helper(costs, 0,0,0);
		int case2 = helper(costs, 0,0,1);
		int case3 = helper(costs, 0,0,2);
		return Math.min(case1, Math.min(case2, case3));
	}
	private static int helper(int[][] costs, int row, int cost, int lastColor) {
		//base
		if(row == costs.length)return cost;
		//logic
		int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;
		if(lastColor == 0) {
			case1 = Math.min(helper(costs, row+1, cost+costs[row][1], 1), helper(costs,row+1,cost+costs[row][2],2));
		}
		if(lastColor == 1) {
			case2 = Math.min(helper(costs, row+1, cost+costs[row][0], 0), helper(costs,row+1,cost+costs[row][2],2));
		}
		if(lastColor == 2) {
			case3 = Math.min(helper(costs, row+1, cost+costs[row][0], 0), helper(costs,row+1,cost+costs[row][1],1));
		}
		return Math.min(case1, Math.min(case2, case3));
	}
	*/

	public static void main(String[] args) {
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		int result = minCost(costs);
		System.out.println(result);
	}

}
