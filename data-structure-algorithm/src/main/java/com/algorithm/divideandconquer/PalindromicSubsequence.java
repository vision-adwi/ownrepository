package com.algorithm.divideandconquer;

public class PalindromicSubsequence {
	
	private static int lpsCount(String word, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}

		if (word.charAt(start) == word.charAt(end)) {
			return 2 + lpsCount(word, start + 1, end - 1);
		} else {
			int count1 = lpsCount(word, start + 1, end);
			int count2 = lpsCount(word, start, end - 1);
			
			return Math.max(count1, count2);
		}
	}

	public static void main(String[] args) {
		String word = "AMEEWMEA";
		//String word = "ELRMENMET";
		System.out.println(lpsCount(word, 0, word.length() - 1));
	}

}
