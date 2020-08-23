package com.algorithm.dynamicprogramming.topdown;

import com.algorithm.IPalindromicSubsequence;

public class PalindromicSubsequence implements IPalindromicSubsequence{
	@Override
	public int lps(String word) {
		int[][] mem = new int[word.length()][word.length()];
		return lpsCount(word, 0, word.length() - 1, mem);
	}
	
	private int lpsCount(String word, int front, int rear, int[][] mem) {
		if (front > rear) {
			return 0;
		}
		if (front == rear) {
			return 1;
		}

		if (mem[front][rear] == 0) {
			int count1 = 0;
			int count2 = 0;
			if (word.charAt(front) == word.charAt(rear)) {
				count1 = 2 + lpsCount(word, front + 1, rear - 1, mem);
			} else {
				count1 = lpsCount(word, front + 1, rear, mem);
				count2 = lpsCount(word, front, rear - 1, mem);
			}
			mem[front][rear] = Math.max(count1, count2);
		}

		return mem[front][rear];
	}

}
