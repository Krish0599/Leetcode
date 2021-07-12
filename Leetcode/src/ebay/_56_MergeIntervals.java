package ebay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class _56_MergeIntervals {

	class customComparator implements Comparator<int []>{
        public int compare(int[] a, int[] b){
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        }
    }
    public int[][] merge(int[][] intervals) {
        if(intervals== null || intervals.length==0)return new int[][]{};
        Arrays.sort(intervals, new customComparator());
        List<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int [] prev = result.get(result.size()-1);
            int [] curr = intervals[i];
            if(prev[1] >= curr[0]){
                result.get(result.size()-1)[1] = Math.max(curr[1], result.get(result.size()-1)[1]);
            }else{
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()-1][]);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
