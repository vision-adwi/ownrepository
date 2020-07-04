package com.practice.slidingwindow;
/*
Leetcode#567. Permutation in String
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
In other words, one of the first string's permutations is the substring of the second string.
*/
public class PermutationsInString {
    public boolean checkInclusion(String s1, String s2) {
    	char[] s1Chars = s1.toCharArray();
    	char[] s2Chars = s2.toCharArray();
    	
    	int i = 0, j = 0, k = 0;
    	while(i < s2Chars.length) {
    		j = i;
    		char[] s1Clone = s1Chars.clone();
    		k = s1Clone.length;
    		
    		while(j < s2Chars.length && isFound(s1Clone, s2Chars[j++])) {
    			k--;
    			if(k == 0)
    				return true;
    		}

    		i++;
    	}
    	
    	return false;       
    }
    
    private boolean isFound(char[] chars, char ch) {
    	boolean found = false;
    	for(int i = 0; i < chars.length; i++) {
    		if(chars[i] == ch) {
    			found = true;
    			chars[i] = ' ';
    			break;
    		}
    	}
    	
    	return found;
    }
    
    public static void main(String[] s) {
    	PermutationsInString perm = new PermutationsInString();
    	System.out.println(perm.checkInclusion("aboe", "eidbaooo"));
    }
}
