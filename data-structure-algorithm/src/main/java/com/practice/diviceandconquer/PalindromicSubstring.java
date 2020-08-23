package com.practice.diviceandconquer;
/*
Leetcode#5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*/
public class PalindromicSubstring {
	public String longestPalindrome_dp(String s) {
		if(s.length() == 0)
			return "";
		
		int[][] mem = new int[s.length()][s.length()];
		
		int from = 0, to = 0;
		int max = 0;
		for(int column = 0; column < s.length(); column++) {
			for(int row = s.length() - 1; row >= 0; row--) {
				if(row == column) {
					mem[row][column] = 1;
				}
				else if(row > column) {
					mem[row][column] = 0;
				}
				else {
					int l1 = 0;
					if(s.charAt(row) == s.charAt(column)) {
						if(mem[row + 1][column - 1] == column - row - 1) {
							l1 = 2 + mem[row + 1][column - 1];
						}
					}
					if(l1 > max) {
						max = l1;
						from = row;
						to = column;
					}
					
					mem[row][column] =  Math.max(l1, Math.max(mem[row + 1][column], mem[row][column - 1]));
				}
			}
		}
		

		return s.substring(from, to+1);
	}

	
	public String longestPalindrome(String s) {
		String[][] mem = new String[s.length()][s.length()];
		return findPalindrome(s, 0, s.length() - 1, mem);
	}
	
	private static String findPalindrome(String word, int start, int end, String[][] mem) {
		if (start > end) {
			return "";
		}
		if (start == end) {
			return word.substring(start, end + 1);
		}

		if (mem[start][end] == null) {
			String count1 = "";
			if (word.charAt(start) == word.charAt(end)) {
				int remainingLength = end - start - 1;
				if (findPalindrome(word, start + 1, end - 1, mem).length() == remainingLength)
					count1 = word.substring(start, end + 1);
			}
			String count2 = findPalindrome(word, start + 1, end, mem);
			String count3 = findPalindrome(word, start, end - 1, mem);

			String tmp = count1.length() > count2.length() ? count1 : count2;
			mem[start][end] = tmp.length() > count3.length() ? tmp : count3;
		}

		return mem[start][end];
	}

	public static void main(String[] s) {
		PalindromicSubstring substring = new PalindromicSubstring();
		System.out.println(substring.longestPalindrome("cbbd"));
	}

}
