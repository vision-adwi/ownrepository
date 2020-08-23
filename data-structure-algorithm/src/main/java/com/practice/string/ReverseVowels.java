package com.practice.string;
/*
Leetcode#345. Reverse Vowels of a String
Write a function that takes a string as input and reverse only the vowels of a string.
*/
public class ReverseVowels {
    public String reverseVowels(String s) {
    	char[] chars = s.toCharArray();
    	
    	int i = 0;
    	int j = chars.length - 1;
    	while(true) {
    		while(i < chars.length && !isVowel(chars[i]))
    			i++;
    		
    		while(j >= 0 && !isVowel(chars[j]))
    			j--;
    		
    		if(i > j)
    			break;
    		
    		char tmp;
    		tmp = chars[i];
    		chars[i++] = chars[j];
    		chars[j--] = tmp; 		
    	}
        
    	return new String(chars);
    }
    
    private boolean isVowel(char ch) {
    	boolean lowercase = (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u');
    	boolean uppercase = (ch == 'A') || (ch == 'E') || (ch == 'I') || (ch == 'O') || (ch == 'U');
    	
    	return lowercase || uppercase;
    }

}
