package com.practice.string;
/*
Leetcode#151. Reverse Words in a String
Given an input string, reverse the string word by word.
*/
public class ReverseWordsInString {
	public String reverseWords(String s) {
		char[] chars = s.toCharArray();
		
		StringBuilder sentence = new StringBuilder();
		StringBuilder word;
		for(int i = 0; i < chars.length;) {
			while(i < chars.length && chars[i] == ' ')
				i++;
			
			word = new StringBuilder();
			while(i < chars.length && chars[i] != ' ') {
				word.append(chars[i++]);
			}
			
			if(word.length() > 0) {
				if(sentence.length() > 0) {
					sentence.insert(0, ' ');
				}
				
				sentence.insert(0, word.toString());
			}
			
		}
        
		return sentence.toString();
    }
	
	public static void main(String[] s) {
		ReverseWordsInString reverse = new ReverseWordsInString();
		String s1 = "  Vande   Mataram!!  ";
		System.out.println(reverse.reverseWords(s1));
	}

}
