package com.algorithm.divideandconquer;

import com.algorithm.IPalindromicSubsequence;

public class PalindromicSubsequence implements IPalindromicSubsequence{
	@Override
	public int lps(String word) {
		return lpsCount(word, 0, word.length() - 1);
	}
	
	private int lpsCount(String word, int front, int rear) {
		if (front > rear) {
			return 0;
		}
		if (front == rear) {
			return 1;
		}

		int count1 = 0;
		int count2 = 0;
		if (word.charAt(front) == word.charAt(rear)) {
			count1 = 2 + lpsCount(word, front + 1, rear - 1);
		} else {
			count1 = lpsCount(word, front + 1, rear);
			count2 = lpsCount(word, front, rear - 1);	
		}
		
		return Math.max(count1, count2);
	}
}
