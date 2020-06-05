package com.algorithm.divideandconquer;

import com.algorithm.IPalindromicSubstring;

public class PalindromicSubstring implements IPalindromicSubstring{
	
	private static int lpsCount(String word, int start, int end) {
		if(start > end) {
			return 0;
		}
		if(start == end) {
			return 1;
		}

		int count1 = 0;
		if (word.charAt(start) == word.charAt(end)) {
			int remainingLength = end - start - 1;
			if(remainingLength == lpsCount(word, start + 1, end - 1))
				count1 = 2 + remainingLength;
		}
		int count2 = lpsCount(word, start + 1, end);
		int count3 = lpsCount(word, start, end - 1);

		return Math.max(Math.max(count1, count2), count3);
	}

	@Override
	public int maxSize(String s) {
		return lpsCount(s, 0, s.length() - 1);
	}

}
