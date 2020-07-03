package com.practice.string;
/*
Leetcode#557. Reverse Words in a String III
Given a string, you need to reverse the order of characters in each word within a sentence 
while still preserving whitespace and initial word order.
*/
public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        char[] original = s.toCharArray();

        int i = 0; 
        while(i < original.length) {
        	int k = i;
            while(i < original.length && original[i++] != ' ');
            
            int j = (i == original.length) ? (i - 1) : (i - 2);
            while(j > k) {
            	char tmp = original[j];
            	original[j--] = original[k];
            	original[k++] = tmp;
            }
        }
        
        return new String(original);
    }
	
	public static void main(String[] s) {
		ReverseWordsInStringIII reverse = new ReverseWordsInStringIII();
		String s1 = "Let's take LeetCode contest";
		System.out.println(reverse.reverseWords(s1));
	}

}
