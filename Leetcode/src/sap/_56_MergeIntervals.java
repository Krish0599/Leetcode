package sap;
import java.util.*;

//Solution-1 -> compare all two intervals and merge T - O(n^2) ; S - O(1)

//Solution-2 -> sort and iterate once to compare adjacent intervals T - O(nlogn) ; S - sorting space

//Solution-3 -> pq 
public class _56_MergeIntervals {
	
	/* Solution -1 
	public static int[][] merge(int[][] intervals){
		//base
		if(intervals == null || intervals.length <2)return intervals;
		
		List<int[]> result = new ArrayList<>();
		for(int i=0;i<intervals.length;i++){
            int[] prev = intervals[i];
            for(int j=i+1;j<intervals.length;j++){
                int[] curr = intervals[j];
                
                //compare and merge
                //{2,4},{3,6}
                //{3,6},{2,4}
                if(prev[1] >= curr[0] && prev[0] <= curr[1]){
                    curr[0] = Math.min(prev[0], curr[0]);
                    curr[1] = Math.max(prev[1], curr[1]);
                    
                    prev[0] = prev[1] = -1;
                }
            }
        }
		for(int[] interval:intervals){
            if(interval[0] != -1 && interval[1] != -1){
                result.add(interval);
            }
        }
		return result.toArray(new int[result.size()][2]);
	}
	*/
	
	//Solution-2 Sort
	/*
	public static int[][] merge(int[][] intervals){
		//sort the intervals
		Arrays.sort(intervals, (a,b)->{
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
		
		List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++){
            int[] prev = result.get(result.size()-1);
            int prev_start = prev[0];
            int prev_end = prev[1];
            
            int[] curr = intervals[i];
            int curr_start = curr[0];
            int curr_end = curr[1];
            
            if(prev_end >= curr_start){
                result.get(result.size()-1)[1] = Math.max(prev_end, curr_end);
            }else{
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()-1][]);
	}
	*/
	
	//Solution-3 PriorityQueue
	public static int[][] merge(int[][] intervals){
		List<int[]> result = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
                return a[1] - b[1];
            }
        });
        //add all elements to pq
        for(int[] interval:intervals){
            pq.add(interval);
        }
        //for each poll, iterate till overlapping
        while(!pq.isEmpty()){
            int[] prev = pq.poll();
            
            while(!pq.isEmpty() && prev[1] >= pq.peek()[0]){
                int[] curr = pq.poll();
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
            result.add(prev);
        }
        return result.toArray(new int[result.size()][2]);
	}
	
	public static void main(String[] args) {
		int[][] input = {{1,3},{2,6},{8,10},{15,18}};
		int[][] res = merge(input);
		for(int[] in:res) {
			System.out.print(Arrays.toString(in));
			System.out.print(" , ");
		}
	}

}
