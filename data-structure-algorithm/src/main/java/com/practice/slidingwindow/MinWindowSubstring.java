package com.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;
/*
Leetcode#76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
*/
public class MinWindowSubstring {
	public String minWindow(String s, String t) {
		int i = 0, j = 0;
		CharSets charSets = new CharSets(t);
		
		int min = Integer.MAX_VALUE;
		String result = "";
		while(j < s.length()) {
			char c = s.charAt(j++);
			charSets.remove(c);
			
			while(charSets.exhausted()) {
				if((j - i) < min) {
					min = (j - i);
					result = s.substring(i, j);
				}

				c = s.charAt(i++);
				charSets.add(c);
			}
		}
		
		return result;
	}
	
    public String minWindow_(String s, String t) {
    	CharSets charSets = new CharSets(t);
    	String result = s;
    	boolean found = false;
    	int left = 0, right = 0;
    	while(true) {
    		while(!charSets.exhausted() && right < (s.length())) {
    			charSets.remove(s.charAt(right++));
    		}
    		
    		if(result.length() > (right-left)) {
    			result = s.substring(left, right);
    		}
    		
    		while(charSets.exhausted()) {
    			found = true;
    			charSets.add(s.charAt(left++));
    		}
    		
    		if(result.length() > ((right-left) + 1)) {
    			result = s.substring(left - 1, right);
    		}
    		
    		if(right == s.length())
    			break;
    	}
        
    	return !found ? "" : result;
    }
    
    public static void main(String[] s) {
    	MinWindowSubstring subString = new MinWindowSubstring();
    	System.out.println(subString.minWindow("bba", "ab"));
    	//System.out.println(subString.minWindow("ADOBECODEBANC", "ABC"));
    }
}

class CharSets {
	Map<Character, Integer> freqMap;
	int elements;
	
	CharSets(String t) {
		freqMap = new HashMap<>();
		while(elements < t.length()) {
			Character c = t.charAt(elements);
			int frequency = freqMap.getOrDefault(c, 0);
			freqMap.put(c, ++frequency);
			
			elements++;
		}
	}
	
	void remove(Character c) {
		Integer frequency = freqMap.get(c);
		if (frequency != null) {
			if(frequency > 0)
				--elements;
			
			freqMap.put(c, --frequency);
		}
	}
	
	void add(Character c) {
		Integer frequency = freqMap.get(c);
		if (frequency != null) {
			freqMap.put(c, ++frequency);
			
			if(frequency > 0)
				++elements;
		}
	}
	
	boolean exhausted() {
		return elements == 0;
	}
}
