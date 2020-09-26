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
        while(true) {
        	while(i < original.length && original[i] == ' ')
            	i++;
        	
        	if(i >= original.length)
        		break;
        	
        	int k = i;        	
        	while(i < original.length && original[i] != ' ') {
        		i++;
        	}
        	
            int j = i - 1;
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
		String s1 = " Let's take LeetCode contest ";
		System.out.println(reverse.reverseWords(s1));
	}

}
