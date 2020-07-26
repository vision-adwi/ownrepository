package com.practice.string;
/*
Leetcode#214. Shortest Palindrome
Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.
*/
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		int i = s.length();
		while (i > 0) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				if (s.charAt(left) != s.charAt(right))
					break;
				
				++left; --right;
			}
			if(left >= right)
				break;
			
			--i;
		}
		
		StringBuilder remaining = (i < s.length()) ? new StringBuilder(s.substring(i)) :
			new StringBuilder("");
		StringBuilder result = remaining.reverse().append(s);
		
		return result.toString();
	}
	
	public static void main(String[] s) {
		ShortestPalindrome palindrome = new ShortestPalindrome();
		System.out.println(palindrome.shortestPalindrome("abcd"));
	}

}
