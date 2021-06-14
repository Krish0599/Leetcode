package mis.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class OptimisingBoxWeights {

	public static void main(String[] args) {
		int n = 5;
		int[] arr = {3,7,5,6,2};
		List<Integer> result = method(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		System.out.println(result);
	}
	
//	private static int[] method(int[] arr) {
//		if(arr==null || arr.length ==0) return arr;
//		ArrayList<Integer> result = new ArrayList<>();
//		int sum =0;
//		for(int i=0;i<arr.length;i++) {
//			sum +=arr[i];
//		}
//		int target = sum / 2;
//		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
//	        return b - a;
//	    });
//		pq.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
//		
//	    int localSum= 0;
//	    while (localSum <= target) {
//	        int arrVal= pq.poll();
//	        localSum += arrVal;
//	        result.add(arrVal);
//	    }
//	    Collections.reverse(result );
//	    return result.stream().mapToInt(i -> i).toArray();
//	}
	private static List<Integer> method(List<Integer> arr) {
		if(arr==null || arr.size() ==0) return arr;
		ArrayList<Integer> result = new ArrayList<>();
		int sum =0;
		for(int i=0;i<arr.size();i++) {
			sum +=arr.get(i);
		}
		int target = sum/2;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			return b-a;
		});
		pq.addAll(arr);
		int localSum=0;
		while (localSum <= target) {
			int arrVal= pq.poll();
			localSum += arrVal;
			result.add(arrVal);
		}
		Collections.reverse(result);
		return result;
	}
	

}
