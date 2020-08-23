package com.practice.string;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#443. String Compression
Given an array of characters, compress it in-place.
The length after compression must always be smaller than or equal to the original array.
Every element of the array should be a character (not int) of length 1.
After you are done modifying the input array in-place, return the new length of the array.
*/		
public class StringCompression {
    public int compress(char[] chars) {
    	int i = 0, j = 0;
    	while(i < chars.length) {
    		int freq = 1;
    		while((i < (chars.length - 1)) && chars[i] == chars[i + 1]) {
    			i++;
    			freq++;
    		}
    		chars[j++] = chars[i++];
    		if(freq > 1) {
    			List<Character> digits = new ArrayList<>();  			
    			while(freq != 0) {
    				digits.add(0, (char)((freq % 10) + 48));
    				freq = freq / 10;
    			}
    			
    			for(char digit : digits) {
    				chars[j++] = digit;
    			}   			
    		}
    	}
    	
    	return j;
    }
}
