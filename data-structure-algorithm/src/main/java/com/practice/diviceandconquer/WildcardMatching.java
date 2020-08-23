package com.practice.diviceandconquer;
/*
Leetcode#44. Wildcard Matching
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
*/
public class WildcardMatching {
	public boolean isMatch_dp(String s, String p) {
		boolean[][] mem = new boolean[s.length() + 1][p.length() + 1];
		
		mem[0][0] = true;
		for(int i = 1; i <= p.length(); i++) {
			if(p.charAt(i - 1) == '*') {
				mem[0][i] = mem[0][i - 1];
			}
			else {
				mem[0][i] = false;
			}
		}
		
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= p.length(); j++) {
				if((s.charAt(i - 1) == p.charAt(j - 1)) || p.charAt(j - 1) == '?') {
					mem[i][j] = mem[i - 1][j - 1];
				}
				else if(p.charAt(j - 1) == '*') {
					mem[i][j] = mem[i - 1][j] || mem[i][j - 1];
				}
				else {
					mem[i][j] = false;
				}
			}
		}
		
		return mem[s.length()][p.length()];
	}
    public boolean isMatch(String s, String p) {
        return matches(s, 0, p, 0);
    }
    
    private boolean matches(String s, int sIndex, String p, int pIndex) {
    	if(sIndex >= s.length() && pIndex >= p.length())
    		return true;
    	
    	if(pIndex >= p.length())
    		return false;
    	
    	if(p.charAt(pIndex) == '*' && pIndex != (p.length() - 1) && sIndex == (s.length() - 1))
    		return false;
    	
    	if(p.charAt(pIndex) == '*') {
    		boolean take = matches(s, sIndex + 1, p, pIndex);
    		boolean move = matches(s, sIndex, p, pIndex + 1);
    		
    		return take || move;
    	}
    	
    	if(sIndex >= s.length())
    		return false;
    	
    	if((s.charAt(sIndex) == p.charAt(pIndex)) || (p.charAt(pIndex) == '?')) {
    		return matches(s, sIndex + 1, p, pIndex + 1);
    	}
    	   	
    	return false;
    }

}
