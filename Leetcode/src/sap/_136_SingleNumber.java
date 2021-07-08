package sap;
import java.util.HashMap;
import java.util.HashSet;

//Solution-1 Hashmap with number and their counters and iterate map till value is 1 and return.

// Solution-2 HashSet. Add while iterating and when duplicate found remove number. At the end only one entry will be in hasset.

public class _136_SingleNumber {
	
	/*
	public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i, 0);
            }
            map.put(i,map.get(i)+1);
        }
        for(int i:nums){
            if(map.get(i) == 1)return i;
        }
        return 0;
    }
    */
	
	public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            if(!set.contains(i)){
                set.add(i);
            }else{
                set.remove(i);
            }
        }
        for(int i:set){
            return i;
        }
        return -1;
    }

	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		int res = singleNumber(nums);
		System.out.println(res);
	}

}
