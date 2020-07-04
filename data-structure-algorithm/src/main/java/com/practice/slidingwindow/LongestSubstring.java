package com.practice.slidingwindow;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
    	if(s.isEmpty())
    		return 0;
    	
    	byte[] chars = new byte[26];
    	byte[] sBytes = s.getBytes();
    	
    	int max = 0;
    	int i = 0;
    	int j = 0;
    	
    	while(j < sBytes.length) {
    		int b = sBytes[j] - 97;
    		if(chars[b] == 0) {
    			chars[b] = 1;
    			j++;
    			max = Math.max(max, (j - i));
    		}
    		else {
    			b = sBytes[i++] - 97;
    			chars[b] = 0;
    		}
    	}
    	
    	return max;
    }
}
