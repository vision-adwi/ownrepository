package com.practice.slidingwindow;

//Leetcode#3. Longest Substring Without Repeating Characters

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
    	int[] chars = new int[128];

    	int max = 0;
    	for(int i =0, j = 0; j < s.length();) {
    		char aChar = s.charAt(j);
    		if(chars[aChar] == 0) {
    			chars[aChar]++;
    			max = Math.max(max, ((j - i) + 1));
    		}
    		else {
    			char bChar = s.charAt(i++);
    			while(bChar != aChar) {
    				chars[bChar]--;
    				bChar = s.charAt(i++);
    			}
    		}
    		
    		j++;
    	}
    	
    	return max;
    }
    
    public static void main(String[] s) {
    	LongestSubstring longest = new LongestSubstring();
    	System.out.println(longest.lengthOfLongestSubstring(" "));
    }
}
