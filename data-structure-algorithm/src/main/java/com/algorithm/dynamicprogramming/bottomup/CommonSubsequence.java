package com.algorithm.dynamicprogramming.bottomup;

import com.algorithm.ICommonSubsequence;

public class CommonSubsequence implements ICommonSubsequence{
	@Override
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
}
