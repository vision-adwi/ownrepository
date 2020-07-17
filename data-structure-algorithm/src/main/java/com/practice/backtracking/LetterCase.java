package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#784. Letter Case Permutation
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  
Return a list of all possible strings we could create.
*/
public class LetterCase {
    public List<String> letterCasePermutation(String S) {
    	List<String> result = new ArrayList<>();
    	StringBuilder builder = new StringBuilder(); int index = 0;
    	while(index < S.length() && Character.isDigit(S.charAt(index))) {
    		builder.append(S.charAt(index));
    		index++;
    	}
    	combination(S, index, builder, result);
    	return result;
    }
    
    private void combination(String S, int index, StringBuilder builder, List<String> result) {
    	if(index == S.length()) {
    		result.add(builder.toString());
    		return;
    	}
    	
    	for(int i = 0; i < 2; i++) {
    		char character = (i == 0) ? Character.toLowerCase(S.charAt(index++)) :
    			Character.toUpperCase(S.charAt(index++));
    		
    		builder.append(character);
        	while(index < S.length() && Character.isDigit(S.charAt(index))) {
        		builder.append(S.charAt(index));
        		index++;
        	}
        	
        	combination(S, index, builder, result);

        	while(index > 0 && Character.isDigit(S.charAt(--index))) {
        		builder.setLength(builder.length() - 1);
        	}
        	builder.setLength(builder.length() - 1);
    	}
    }
    
    public static void main(String[] s) {
    	LetterCase letterCase = new LetterCase();
    	System.out.println(letterCase.letterCasePermutation("1a11b"));
    }
}
