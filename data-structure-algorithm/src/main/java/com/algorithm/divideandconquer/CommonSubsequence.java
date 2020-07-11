package com.algorithm.divideandconquer;

import com.algorithm.ICommonSubsequence;

public class CommonSubsequence implements ICommonSubsequence{
	@Override
	public int lcs(String s1, String s2) {
		return largestSubsequence(s1, s2, 0, 0);
	}

	public int largestSubsequence(String s1, String s2, int idx1, int idx2) {
		if(idx1 >= s1.length() || idx2 >= s2.length())
			return 0;
		
		int l1 = 0;
		int l2 = 0;
		if(s1.charAt(idx1) == s2.charAt(idx2)) {
			l1 = 1 + largestSubsequence(s1, s2, idx1 + 1, idx2 + 1);
		}
		else {
			l1 = largestSubsequence(s1, s2, idx1 + 1, idx2);
			l2 = largestSubsequence(s1, s2, idx1, idx2 + 1);
		}
		 
		return Math.max(l1, l2);
	}
}
