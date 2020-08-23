package com.practice.diviceandconquer;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
Leetcode#139. Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be 
segmented into a space-separated sequence of one or more dictionary words.
*/
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dictionary = new HashSet<>(wordDict);
		return breakIt(s, dictionary);		
	}
	
	private boolean breakIt(String s, Set<String> dictionary) {
		if(s.isEmpty())
			return true;

		for(int i = 1; i <= s.length(); i++) {
			if(dictionary.contains(s.substring(0, i))) {
				if(breakIt(s.substring(i), dictionary))
					return true;
			}
		}
		
		return false;
	}
	
	private boolean breakIt_td(String s, Set<String> dictionary, Map<String, Boolean> mem) {
		if(s.isEmpty())
			return true;

		boolean response = false;
		if (!mem.containsKey(s)) {
			for (int i = 1; i <= s.length(); i++) {
				if (dictionary.contains(s.substring(0, i))) {
					if (breakIt_td(s.substring(i), dictionary, mem)) {
						response = true;
						break;
					}
				}
			}
			mem.put(s, response);
		}
		
		return mem.get(s);
	}
	
	

}
