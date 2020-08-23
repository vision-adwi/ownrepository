package com.practice.dynamicprogramming;

public class HardAndTough {
	/*
	Leetcode#5. Longest Palindromic Substring
	Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
	*/
	public int lpSubstring(String s) {
		int size = s.length();
		int[][] mem = new int[size][size];

		for(int col = 0; col < size; col++) {
			for(int row = size - 1; row >= 0; row--) {
				if(row == col) {
					mem[row][col] = 1;
				}
				else if(row > col) {
					mem[row][col] = 0;
				}
				else {
					if(s.charAt(row) == s.charAt(col)) {
						int l1 = 0;
						if((col - row - 1) == mem[row + 1][col - 1]) {
							l1 = 2 + mem[row + 1][col - 1];
						}
						mem[row][col] = Math.max(l1, Math.max(mem[row + 1][col], mem[row][col - 1]));
					}
					else {
						mem[row][col] = Math.max(mem[row + 1][col], mem[row][col - 1]);
					}
				}
			}
		}
		
		return mem[0][size - 1];
		//return s.substring(minFrom, maxTo + 1);
	}
	
	/*
	Leetcode#887. Super Egg Drop
	*/
	public int superEggDrop(int K, int N) {
		return -1;
	}
	
	/*
	Leetcode#10. Regular Expression Matching
	Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	The matching should cover the entire input string (not partial).
	*/
	public boolean isMatch(String s, String p) {
		return false;
	}
}
