package com.practice.slidingwindow;
/*
Leetcode#1456. Maximum Number of Vowels in a Substring of Given Length
Given a string s and an integer k.

Return the maximum number of vowel letters in any substring of s with length k.
*/
public class MaxVowels {
	public int maxVowels(String s, int k) {
		int i = 0;
		int j = 0;
		
		int count = 0;
		int max = 0;
		while(j < s.length()) {
			if(isVowel(s.charAt(j++))) {
				count++;	
			}
			
			if((j - i) > k) {
				if(isVowel(s.charAt(i++)))
					count--;
			}
			
			max = Math.max(max, count);
		}
		
		return max;
	}
	
	private boolean isVowel(char ch) {
		return ( (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u') );
	}
	
	public static void main(String[] s) {
		MaxVowels vow = new MaxVowels();
		System.out.println(vow.maxVowels("aeiou", 2));
	}

}
