package sap;

import java.util.ArrayList;

public class _57_InsertInterval {
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        
        // add all intervals before newInterval
        int i = 0;
        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < newInterval[0]) {
                ans.add(intervals[i]);
            } else {
                break;
            }
        }
        
        // now add newInterval and merge if anymerges are possible
        if (ans.isEmpty() || ans.get(ans.size()-1)[1] < newInterval[0]) {
            ans.add(newInterval);
        } else {
            ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], newInterval[1]);
        }

        // add all intervals after newInterval with merging whenever applicable
        while (i < intervals.length) {
            if (ans.get(ans.size()-1)[1] < intervals[i][0]) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
            }
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

	public static void main(String[] args) {
	}

}
