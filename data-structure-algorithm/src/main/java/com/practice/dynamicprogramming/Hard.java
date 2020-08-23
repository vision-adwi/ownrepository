package com.practice.dynamicprogramming;

import java.util.List;

public class Hard {
	/*
	Leetcode#72. Edit Distance {Hard}
	Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
	You have the following 3 operations permitted on a word:

	Insert a character
	Delete a character
	Replace a character
	*/
    public int minDistance(String word1, String word2) {
        int s_length = word1.length();
        int t_length = word2.length();
        
        int[][] mem = new int[s_length + 1][t_length + 1];
        int x = 1;
        for(int i = s_length - 1; i >= 0; i--)
            mem[i][t_length] = x++;
        
        x= 1;
        for(int j = t_length - 1; j >= 0; j--)
            mem[s_length][j] = x++;
        
        for(int i = s_length; i > 0; i--) {
            for(int j = t_length; j > 0; j--) {
                if(word1.charAt(s_length - i) == word2.charAt(t_length - j)) {
                    mem[i-1][j-1] = mem[i][j];
                }
                else {
                    mem[i-1][j-1] = 1 + Math.min(Math.min(mem[i-1][j], mem[i][j-1]), mem[i][j]);
                }
            }
        }
        
        return mem[0][0];
    }
    
    /*
    Leetcode#115. Distinct Subsequences
    Given a string S and a string T, count the number of distinct subsequences of S which equals T.
    A subsequence of a string is a new string which is formed from the original string by deleting some 
    (can be none) of the characters without disturbing the relative positions of the remaining characters. 
    (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
    It's guaranteed the answer fits on a 32-bit signed integer.
    */
    public int numDistinct(String s, String t) {
        int s_length = s.length();
        int t_length = t.length();
        
        int mem[][] = new int[s_length + 1][t_length + 1];
        for(int i = 0; i < mem.length; i++)
            mem[i][t_length] = 1;
        
        for(int i = s_length; i > 0; i--) {
            for(int j = t_length; j > 0; j--) {
                if(s.charAt(s_length - i) == t.charAt(t_length - j)) {
                    mem[i - 1][j - 1] = mem[i][j] + mem[i][j - 1];
                }
                else {
                    mem[i - 1][j - 1] = mem[i][j - 1];
                }
            }
        }
           
        return mem[0][0];
    }
    
    /*
    Leetcode#1143. Longest Common Subsequence
    Given two strings text1 and text2, return the length of their longest common subsequence.

    A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted 
    without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). 
    A common subsequence of two strings is a subsequence that is common to both strings.

    If there is no common subsequence, return 0.
    */
	public int lcs(String s1, String s2) {
		int[][] mem = new int[s1.length() + 1][s2.length() + 1];
		
		for(int i = s1.length(); i > 0; i--) {
			for(int j = s2.length(); j > 0; j--) {
				if(s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j)) {
					mem[i - 1][j - 1] = 1 + mem[i][j];
				}
				else {
					mem[i - 1][j - 1] = Math.max(mem[i - 1][j], mem[i][j - 1]);
				}
			}
		}
		
		
		return mem[0][0];
	}
	
	/*
	Leetcode#516. Longest Palindromic Subsequence
	Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
	*/
	public int lps(String word) {
		int[][] mem = new int[word.length()][word.length()];

		for(int column = 0; column < word.length(); column++) {
			for(int row = word.length() - 1; row >= 0; row--) {
				if( row == column) {
					mem[row][column] = 1;
				}
				else if( row > column) {
					mem[row][column] = 0;
				}
				else {
					if(word.charAt(row) == word.charAt(column)) {
						mem[row][column] = 2 + mem[row + 1][column - 1];
					}
					else {
						mem[row][column] = Math.max(mem[row][column - 1], mem[row + 1][column]);
					}
				}
			}
		}
		
		return mem[0][word.length() - 1];
	}
	
	/*
	Leetcode#188. Best Time to Buy and Sell Stock IV
	Say you have an array for which the i-th element is the price of a given stock on day i.
	Design an algorithm to find the maximum profit. You may complete at most k transactions.
	*/
    public int transaction(int k, int[] prices) {
    	int len = prices.length;
    	if(len <= 1 || k < 1)
    		return 0;
    	
    	if(k > (len / 2)) {
    		int profit = 0;
    		for(int i = 0; i < len - 1; i++) {
    			if(prices[i] < prices[i + 1])
    				profit += prices[i + 1] - prices[i];
    		}
    		return profit;
    	}

    	int[] target;
    	
    	int[] source = new int[len];
    	
    	while(k-- > 0) {
    		target = new int[len];
    		for(int j = 1; j < len; j++) {
    			int sellPrice = prices[j];
    			
    			int trxMax = 0;
    			for(int t = j - 1; t >= 0; t--) {
    				trxMax = Math.max(trxMax, (sellPrice - prices[t]) + source[t]);
    			}
    			
    			target[j] = Math.max(target[j - 1], trxMax);
    		}
    		
    		source = target;
    	}
    	
    	return source[len - 1];
    }
    
	/*
	Leetcode#139. Word Break
	Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be 
	segmented into a space-separated sequence of one or more dictionary words.
	*/
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] mem = new boolean[s.length() + 1];
		mem[0] = true;
		
		for(int j = 1; j <= s.length(); j++) {
			for(int i = 0; i < j; i++) {
				if(mem[i] && wordDict.contains(s.substring(i, j))) {
					mem[j] = true;
					break;
				}
			}
		}
		
		return mem[s.length()];
	}
}
