package com.practice.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/*
Leetcode#451. Sort Characters By Frequency
Given a string, sort it in decreasing order based on the frequency of characters.
*/
public class SortCharacters {
	public String frequencySort(String s) {
		Map<Character, Integer> frequency = new HashMap<>();
		for(Character ch : s.toCharArray()) {
			Integer incr = frequency.get(ch);
			if(incr == null)
				incr = 0;
			frequency.put(ch, ++incr);
		}
		
		Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue().compareTo(e1.getValue()));
		
		for(Map.Entry<Character, Integer> entry : frequency.entrySet()) {
			maxHeap.offer(entry);
		}
		
		char[] result = new char[s.length()]; 
		int index = 0;
		while(!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			int occurences = entry.getValue();
			while(occurences-- > 0)
				result[index++] = entry.getKey();
			
		}
		
		return new String(result);
    }
}
