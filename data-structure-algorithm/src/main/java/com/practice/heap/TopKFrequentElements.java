package com.practice.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/*
Leetcode#347. Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.
*/		
public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequency = new HashMap<>();
		for(int num : nums) {
			Integer incr = frequency.get(num);
			if(incr == null)
				incr = 0;
			frequency.put(num, ++incr);
		}

		Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(
				(e1, e2) -> e1.getValue().compareTo(e2.getValue()));
		
		for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			minHeap.offer(entry);
			if(minHeap.size() > k)
				minHeap.poll();
		}
		
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
        	result[i] = minHeap.poll().getKey();
        }
        
        return result;
    }
}
