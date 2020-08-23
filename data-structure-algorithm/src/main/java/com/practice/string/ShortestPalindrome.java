package com.practice.string;
/*
Leetcode#214. Shortest Palindrome
Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.
*/
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {	
		int pivot = s.length();
		while(true) {
			int left = 0;
			pivot--;
			while(pivot > 0 && s.charAt(left) != s.charAt(pivot))
				pivot--;
			
			int right = pivot;
			while(left < right) {
				if(s.charAt(left) != s.charAt(right))
					break;
				++left; --right;
			}
			if(left >= right)
				break;
			
		}
		
		StringBuilder aux = new StringBuilder(s.substring(pivot + 1)).reverse();
		aux.append(s);
		
		return aux.toString();	
	}

	public static void main(String[] s) {
		ShortestPalindrome palindrome = new ShortestPalindrome();
		System.out.println(palindrome.shortestPalindrome("abcd"));
	}

}
