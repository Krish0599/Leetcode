package ebay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
	1.init hashmap and count occurences of elements in nums
	2.init minHeap based on occurence, if two elements have same freq sort in decreasing order
	3.add elements in map into minHeap as array, containing element and occurence
	4.init index to traverse array
	5.loop while minHeap is not empty
	6.grab min element 
	7.keep inserting element into nums while in bounds and occurence > 0
	8.return nums
*/
public class _1636_SortArrayByIncreasingFrequency {
	
	public static int[] frequencySort(int[] nums) {
		//hashmap with number and their count
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        //pq with hashmap tuples
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            minHeap.add(new int[] {entry.getKey(), entry.getValue()});
        }
        
        int index = 0;
        while(!minHeap.isEmpty()){
            int[] min = minHeap.poll();
            while(min[1] > 0){
                nums[index++] = min[0];
                min[1]--;
            }
        }
        return nums;
    }

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,2,3};
		System.out.println(Arrays.toString(frequencySort(nums)));
	}
}
