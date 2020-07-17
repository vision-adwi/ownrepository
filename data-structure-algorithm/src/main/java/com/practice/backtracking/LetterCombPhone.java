package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode#17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/
public class LetterCombPhone {
	char[][] letters = new char[][]
			{
				{'#', '#', '#'},
				{'#', '#', '#'},
				{'a', 'b', 'c'},
				{'d', 'e', 'f'},
				{'g', 'h', 'i'},
				{'j', 'k', 'l'},
				{'m', 'n', 'o'},
				{'p', 'q', 'r', 's'},
				{'t', 'u', 'v'},
				{'w', 'x', 'y', 'z'}
			};

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (!digits.isEmpty()) {
			List<Integer> ints = new ArrayList<>();
			for (Character ch : digits.toCharArray()) {
				ints.add(Character.getNumericValue(ch));
			}
			combinations(res, new StringBuilder(), 0, ints);
		}

		return res;
	}
	
	private void combinations(List<String> res, StringBuilder sb, int pos, List<Integer> ints) {
		if(pos == ints.size()) {
			System.out.println(sb);
			res.add(sb.toString());
			return;
		}

		char[] letterSet = letters[ints.get(pos)];
		for(int i = 0; i < letterSet.length; i++) {
			sb.append(letterSet[i]);
			combinations(res, sb, pos + 1, ints);
			sb.setLength(sb.length() - 1);
		}
	}
	
	public static void main(String[] s) {
		LetterCombPhone phone = new LetterCombPhone();
		phone.letterCombinations("23");
	}

}
