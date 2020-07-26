package com.practice.string;
/*
Leetcode#459. Repeated Substring Pattern
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
*/
public class RepeatedSubstring {
    public boolean repeatedSubstringPattern(String s) {
    	int len = s.length();
    	for(int i = len / 2; i >= 1; i--) {
    		if((len % i ) == 0) {
    			int repeats = len / i;
    			String segment = s.substring(0, i);
    			StringBuilder builder = new StringBuilder();
    			for(int j = 0; j < repeats; j++) {
    				builder.append(segment);
    			}
    			if(builder.toString().equals(s))
    				return true;
    		}
    	}
        
    	return false;
    }
    
    public static void main(String[] s) {
    	RepeatedSubstring repeated = new RepeatedSubstring();
    	System.out.println(repeated.repeatedSubstringPattern("aba"));
    }
}
