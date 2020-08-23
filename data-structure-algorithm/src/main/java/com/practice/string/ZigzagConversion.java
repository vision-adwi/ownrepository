package com.practice.string;
/*
Leetcode#6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
like this: (you may want to display this pattern in a fixed font for better legibility)
*/
public class ZigzagConversion {
    public String convert(String s, int numRows) {  	
    	StringBuilder[] builders = new StringBuilder[numRows];
    	for(int i = 0; i < builders.length; i++)
    		builders[i] = new StringBuilder();

    	int sIdx = 0;
    	while(sIdx < s.length()) {
    		int index = 0;
    		while(sIdx < s.length() && index < numRows) {
    			builders[index++].append(s.charAt(sIdx++));   			
    		}
    		
    		index = numRows - 2;
    		while(sIdx < s.length() && index > 0) {
    			builders[index--].append(s.charAt(sIdx++)); 
    		}
    	}
    	
    	StringBuilder result = new StringBuilder();
    	for(StringBuilder builder : builders) {
    		result.append(builder);
    	}

        return result.toString();
    }

}
