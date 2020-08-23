package com.practice.diviceandconquer;
/*
Leetcode#115. Distinct Subsequences
Given a string S and a string T, count the number of distinct subsequences of S which equals T.
A subsequence of a string is a new string which is formed from the original string by deleting some 
(can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
It's guaranteed the answer fits on a 32-bit signed integer.
*/
public class DistinctSubsequence {
    public int numDistinct_dp(String s, String t) {
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
    
    public int numDistinct(String s, String t) {
        return countWays(s, t, 0, 0);
    }
    
    
    private int countWays(String s, String t, int sIndex, int tIndex) {
    	if(tIndex >= t.length()) {
    		return 1;
    	}
    	
    	if(sIndex >= s.length())
    		return 0;
    	
    	int l1 = 0;
    	int l2 = 0;
    	if(s.charAt(sIndex) == t.charAt(tIndex)) {
    		l1 = countWays(s, t, sIndex + 1, tIndex + 1);
    		l2 = countWays(s, t, sIndex + 1, tIndex);
    	}
    	else {
    		l2 = countWays(s, t, sIndex + 1, tIndex);
    	}
    	
    	return l1 + l2;
    }
}
