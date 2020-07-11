package com.practice.heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/*
Leetcode#692. Top K Frequent Words
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
*/
public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> frequency = new HashMap<>();
		for(String word : words) {
			Integer incr = frequency.get(word);
			if(incr == null)
				incr = 0;
			frequency.put(word, ++incr);
		}

		Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(
				(e1, e2) -> {
					int freqComp = e1.getValue().compareTo(e2.getValue());
					if(freqComp == 0)
						return e2.getKey().compareTo(e1.getKey());
					else
						return freqComp;
					});
		
		for(Map.Entry<String, Integer> entry : frequency.entrySet()) {
			minHeap.offer(entry);
			if(minHeap.size() > k)
				minHeap.poll();
		}
		
		List<String> result = new LinkedList<>(); 
		while(!minHeap.isEmpty()) {
			result.add(0, minHeap.poll().getKey());
		}

        return result;
	}
}
