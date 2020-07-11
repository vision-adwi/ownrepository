package com.algorithm.dynamicprogramming.topdown;

import com.algorithm.ICommonSubsequence;

public class CommonSubsequence implements ICommonSubsequence{
	@Override
	public int lcs(String s1, String s2) {
		int[][] mem = new int[s1.length() + 1][s2.length() + 1];
		return largestSubsequence(s1, s2, 0, 0, mem);
	}
	
	public int largestSubsequence(String s1, String s2, int idx1, int idx2, int[][] mem) {
		if (idx1 >= s1.length() || idx2 >= s2.length())
			return 0;

		int l1 = 0;
		int l2 = 0;
		if (mem[idx1][idx2] == 0) {
			if (s1.charAt(idx1) == s2.charAt(idx2)) {
				l1 = 1 + largestSubsequence(s1, s2, idx1 + 1, idx2 + 1, mem);
			} else {
				l1 = largestSubsequence(s1, s2, idx1 + 1, idx2, mem);
				l2 = largestSubsequence(s1, s2, idx1, idx2 + 1, mem);
			}

			mem[idx1][idx2] = Math.max(l1, l2);
		}

		return mem[idx1][idx2];
	}
}
