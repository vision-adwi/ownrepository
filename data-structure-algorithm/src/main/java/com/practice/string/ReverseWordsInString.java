package com.practice.string;
/*
Leetcode#151. Reverse Words in a String
Given an input string, reverse the string word by word.
*/
public class ReverseWordsInString {
	public String reverseWords(String s) {
		StringBuilder result = new StringBuilder();
		
		int index = s.length() - 1;
		while(true) {
			while(index >= 0 && s.charAt(index) == ' ')
				index--;
			
			if(index < 0)
				break;
			
			int j = index + 1;
			while(index >= 0 && s.charAt(index) != ' ')
				index--;
			
			if(result.length() > 0)
				result.append(' ');
			result.append(s.substring(index + 1, j));			
		}
		
		return result.toString();
	}
	
	public static void main(String[] s) {
		ReverseWordsInString reverse = new ReverseWordsInString();
		String s1 = "the sky is blue";
		System.out.println(reverse.reverseWords(s1));
	}

}
