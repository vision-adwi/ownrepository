package com.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithDiffIntegers {
	public int subarraysWithKDistinct(int[] A, int K) {
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0, j = 0;
		int count = 0;
		while (j < A.length) {
			if (map.containsKey(A[j])) {
				int val = map.get(A[j]);
				map.put(j++, ++val);
			} else {
				if (K == 0) {
					int val = map.get(A[i]);
					if (val == 1) {
						map.remove(A[i]);
						K++;
					}
					else {
						map.put(A[i], --val);
					}
					i++;
				} else {
					map.put(j++, 1);
					K--;
				}
			}
			
			if (K == 0)
				count++;
		}

		

		return count;
	}
	
	public static void main(String[] s) {
		SubarrayWithDiffIntegers diffIntegers = new SubarrayWithDiffIntegers();
		System.out.println(diffIntegers.subarraysWithKDistinct(new int[] {1,2,1,2,3}, 2));
	}

}
