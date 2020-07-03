package com.practice.slidingwindow;
/*
Leetcode#1456. Maximum Number of Vowels in a Substring of Given Length
Given a string s and an integer k.

Return the maximum number of vowel letters in any substring of s with length k.
*/
public class MaxVowels {
	public int maxVowels(String s, int k) {
		char[] chars = s.toCharArray();
		
		int i = 0, j = 0;
		int vowels = 0;
		int maxVowels = 0;
		int len = k;
		while(i < chars.length) {
			len--;
			if(isVowel(chars[i++]))
				vowels++;
			
			if(len < 0) {
				if(isVowel(chars[j++]))
					vowels--;
			}
			
			maxVowels = vowels > maxVowels ? vowels : maxVowels;
			
			if(k == maxVowels)
				return maxVowels;
		}

		return maxVowels;
	}
	
	private boolean isVowel(char ch) {
		return ( (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u') );
	}
	
	public static void main(String[] s) {
		MaxVowels vow = new MaxVowels();
		System.out.println(vow.maxVowels("abciiidef", 3));
	}

}
