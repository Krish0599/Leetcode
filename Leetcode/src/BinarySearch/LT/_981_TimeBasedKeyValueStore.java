package BinarySearch.LT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

//https://leetcode.com/problems/time-based-key-value-store/

//Solution-1(best) - Hashmap with TreeMap
/*
 1. Here we will be using hashmap with treemap(maintains sorting order).
 2. store keys as hashmap keys and store timestamp and value in treemap with timestamp as keys.
 */

//Solution-2 - Hashmap with ArrayList and binarysearch
public class _981_TimeBasedKeyValueStore {
	
	/*HashMap<String, TreeMap<Integer, String>> map;
	
	public _981_TimeBasedKeyValueStore() {
		map = new HashMap<>();
	}
	
	public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
        	map.put(key, new TreeMap<Integer,String>());
        }
        TreeMap<Integer, String> timeMap = map.get(key);
        timeMap.put(timestamp, value);
    }
	
	public String get(String key, int timestamp) {
		TreeMap<Integer, String> timeMap = map.get(key);
		Integer prevTime = timeMap.floorKey(timestamp);
		if(prevTime == null)return "";
		else return timeMap.get(prevTime);
    }
    */
	
	class Tuple{
		String val;
		int time;
		public Tuple(int timestamp, String value) {
			this.time = timestamp;
			this.val = value;
		}
	}
	
	HashMap<String, ArrayList<Tuple>> map;
	
	public _981_TimeBasedKeyValueStore() {
		map = new HashMap<>();
	}
	
	public void set(String key, String value, int timestamp) {
		if(!map.containsKey(key)) {
			map.put(key, new ArrayList<Tuple>());
		}
		ArrayList<Tuple> al = new ArrayList<>();
		al.add(new Tuple(timestamp, value));
	}
	
	public String get(String key, int timestamp) {
		ArrayList<Tuple> al = map.get(key);
		int index = findFloor(al, timestamp);
		if(index == -1)return "";
		else return map.get(key).get(index).val;
	}
	
	private int findFloor(ArrayList<Tuple> al, int timestamp) {
		int l=0, h=al.size()-1, index=-1;
		if(h==-1)return -1;
		while(h>=l) {
			int m = l+(h-l)/2;
			if(al.get(m).time == timestamp) {
				return m;
			}else if(al.get(m).time > timestamp) {
				h = m-1;
			}else {
				index = m;
				l = m+1;
			}
		}
		return index;
	}
}
