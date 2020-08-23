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
		
		StringBuilder commonPrefix = new StringBuilder();
		
		boolean noExit = true;
		int len = strs[0].length();
		for(int i = 0; i < len && noExit; i++) {
			char ch = strs[0].charAt(i);
			for(String str : strs) {
				if(i >= str.length() || str.charAt(i) != ch) {
					noExit = false;
					break;
				}
			}
			if(noExit)
				commonPrefix.append(ch);
		}
		
		return commonPrefix.toString();		
	}
    
    public static void main(String[] s) {
    	LongestCommonPrefix longPrefix = new LongestCommonPrefix();
    	//String[] input = {"flower","flow","flight"};
    	String[] input = {"dog","racecar","car"};
    	System.out.println(longPrefix.longestCommonPrefix(input));
    }
}
