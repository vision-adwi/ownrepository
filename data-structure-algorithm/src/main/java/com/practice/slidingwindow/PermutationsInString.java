package com.practice.slidingwindow;
/*
Leetcode#567. Permutation in String
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
In other words, one of the first string's permutations is the substring of the second string.
*/
public class PermutationsInString {
    public boolean checkInclusion(String s1, String s2) {
    	int[] frequency = new int[26];
    	for(char ch : s1.toCharArray()) {
    		frequency[ch-'a']++;
    	}
    	
    	int i = 0, j = 0;
    	while(j < s2.length()) {
    		if(frequency[s2.charAt(j)-'a'] > 0) {
    			frequency[s2.charAt(j++)-'a']--;
    		}
    		else if(i == j) {
    			i++; j++;
    		}
    		else {
    			frequency[s2.charAt(i++)-'a']++;
    		}
    		
    		if((j - i) == s1.length())
    			return true;
    	}
    	
    	return false;
    }
    
    public static void main(String[] s) {
    	PermutationsInString perm = new PermutationsInString();
    	System.out.println(perm.checkInclusion("ab", "eidbaooo"));
    }
}
