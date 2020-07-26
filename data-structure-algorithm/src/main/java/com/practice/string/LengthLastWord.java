package com.practice.string;
/*
Leetcode#58. Length of Last Word
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of 
last word (last word means the last appearing word if we loop from left to right) in the string.
If the last word does not exist, return 0.
Note: A word is defined as a maximal substring consisting of non-space characters only.
*/
public class LengthLastWord {
	public int lengthOfLastWord(String s) {
		int count = 0;

		if (!s.isEmpty()) {
			char[] chars = s.toCharArray();
			int index = chars.length - 1;
			while (index >= 0 && chars[index] == ' ')
				index--;
			
			while (index >= 0 && chars[index--] != ' ')
				count++;
		}

		return count;
	}
	
	public static void main(String[] s) {
		LengthLastWord length = new LengthLastWord();
		System.out.println(length.lengthOfLastWord(""));
	}
}
