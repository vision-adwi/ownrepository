package com.practice.string;
/*
Leetcode#14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
*/		
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0)
            return "";
    
    	StringBuilder prefix = new StringBuilder();
    	boolean isExit = false;
    	
    	String firstString = strs[0];
    	for(int i = 0; i < firstString.length(); i++) {
    		prefix.append(firstString.charAt(i));
    		String preString = prefix.toString();
    		for(String s : strs) {
    			if(!s.startsWith(preString)) {
    				isExit = true;
    				prefix.setLength(prefix.length() - 1);
    				break;
    			}
    		}
    		
    		if(isExit)
    			break;
    	}
    	
    	return prefix.toString();
        
    }
/*    
    public String longestCommonPrefix(String[] strs) {
    	String shortestString = strs[0];
    	for(String str : strs) {
    		if(str.length() < shortestString.length() ) {
    			shortestString = str;
    		}
    	}
    	
    	String cachedPrefix = "";
    	String prefix = "";
    	
    	for(int i = 0; i < shortestString.length(); i++) {
    		prefix = prefix + shortestString.charAt(i);
    		
    		for(String s : strs) {
    			if(s.indexOf(prefix) == -1) {
    				if(prefix.length() > 1)
    					--i;
    				
    				prefix = "";
    				break;
    			}
    		}
    		if(!prefix.isEmpty() && (cachedPrefix.length() < prefix.length())) {
    			cachedPrefix = prefix;
    		}
    	}
    	
    	return cachedPrefix;
        
    }*/
    
    public static void main(String[] s) {
    	LongestCommonPrefix longPrefix = new LongestCommonPrefix();
    	//String[] input = {"flower","flow","flight"};
    	String[] input = {"dog","racecar","car"};
    	System.out.println(longPrefix.longestCommonPrefix(input));
    }
}
