package ebay;

/* T-O(nlogn) ; S - O(n)
1)Add all the elements into the PQ.
2)Then loop through the PQ and take the 1st smallest and find its k consicutive numbers. If at least one consicutive number is not present the return false.
3)Last, if the PQ become empty the return true.
*/

/*Another Solution - T-O(nlogn) ; S - O(n)
 * 1. maintain map with numbers and their count
 * 2. sort the array
 * 3. Iterate through array and for every element check for the k consecutive numbers in map and decrement from the map.
 */
import java.util.PriorityQueue;

public class _846_HandOfStraights {
	
	 public static boolean isNStraightHand(int[] hand, int groupSize) {
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        
	        for(Integer i : hand){
	            pq.add(i);
	        }
	        
	        while(!pq.isEmpty()){
	            int curr = pq.poll();
	            for(int j=1; j<groupSize; j++){
	                if(!pq.remove(curr + j)) return false;
	            }
	        }
	        return true;
	  }
	 
	 //Solution-2
	 /*
	  public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c = count.getOrDefault(nums[i],0)+1;
            count.put(nums[i],c);
        }
       
        Arrays.sort(nums);
        for(Integer i:nums){
            if(count.get(i)==0) continue;
            for(int j=i;j<i+k;j++){
                if(count.getOrDefault(j,0)<=0){
                    return false;
                }
                count.put(j,count.get(j)-1);
            }
        }
        return true;
      }
	 */

	public static void main(String[] args) {
		int[] hand = {1,2,3,6,2,3,4,7,8};
		int groupSize = 3;
		System.out.println(isNStraightHand(hand, groupSize));
	}

}
