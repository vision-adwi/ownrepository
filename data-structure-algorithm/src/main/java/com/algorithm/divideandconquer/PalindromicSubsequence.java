package com.algorithm.divideandconquer;

public class PalindromicSubsequence {
	
	private static int lpsCount(String word, int start, int end) {
		if(start > end) {
			return 0;
		}
		if(start == end) {
			return 1;
		}

		int count1 = 0;
		if (word.charAt(start) == word.charAt(end)) {
			count1 = 2 + lpsCount(word, start + 1, end - 1);
		}
		int count2 = lpsCount(word, start + 1, end);
		int count3 = lpsCount(word, start, end - 1);

		return Math.max(Math.max(count1, count2), count3);
	}

	public static void main(String[] args) {
		String word = "orangoutong";
		System.out.println(lpsCount(word, 0, word.length() - 1));
	}

}
