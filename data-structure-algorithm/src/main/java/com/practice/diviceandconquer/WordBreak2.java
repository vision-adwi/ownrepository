package com.practice.diviceandconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Leetcode#140. Word Break II
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
add spaces in s to construct a sentence where each word is a valid dictionary word. Return 
all such possible sentences.
*/
public class WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<String, List<String>> mem = new HashMap<>();
		
		return letsBreakIt(s, wordDict, mem);
	}
	
	private List<String> letsBreakIt(String s, List<String> wordDict, Map<String, List<String>> mem) {	
		if (!mem.containsKey(s)) {
			List<String> result = new ArrayList<>();
			
			if (wordDict.contains(s)) {
				result.add(s);
			}

			for (int i = 1; i <= s.length(); i++) {
				String word = s.substring(0, i);
				if (wordDict.contains(word)) {
					List<String> remaining = letsBreakIt(s.substring(i), wordDict, mem);
					for (String str : remaining) {
						result.add(word + " " + str);
					}
				}
			}
			mem.put(s, result);
		}
		
		return mem.get(s);
	}
	
    public List<String> wordBreak_dc(String s, List<String> wordDict) {
    	List<String> result = new ArrayList<>();
    	if(wordDict.contains(s)) {
    		result.add(s);
    	}
    	
    	for(int i = 1; i <= s.length(); i++) {
    		String word = s.substring(0, i);
    		if(wordDict.contains(word)) {
    			List<String> remaining = wordBreak(s.substring(i), wordDict);
    			for(String str : remaining) {
    				result.add(word + " " + str);
    			}
    		}
    	}
    	
    	return result;
    }

}
