package com.algorithm.dynamicprogramming.topdown;

import com.algorithm.IPalindromicSubstring;

public class PalindromicSubstring implements IPalindromicSubstring{
	
	private static int lpsCount(String word, int start, int end, int[][] mem) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}

		if (mem[start][end] == -1) {
			int count1 = 0;
			if (word.charAt(start) == word.charAt(end)) {
				int remainingLength = end - start - 1;
				if (remainingLength == lpsCount(word, start + 1, end - 1, mem))
					count1 = 2 + remainingLength;
			}
			int count2 = lpsCount(word, start + 1, end, mem);
			int count3 = lpsCount(word, start, end - 1, mem);
			
			mem[start][end] = Math.max(Math.max(count1, count2), count3);
		}

		return mem[start][end];
	}

	@Override
	public int maxSize(String s) {
		int[][] mem = new int[s.length()][s.length()];
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < s.length(); j++) {
				mem[i][j] = -1;
			}
		}
		return lpsCount(s, 0, s.length() - 1, mem);
	}

}
