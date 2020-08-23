package com.practice.string;
/*
Leetcode#848. Shifting Letters
We have a string S of lowercase letters, and an integer array shifts.
Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a'). 
For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.
Return the final string after all such shifts to S are applied.
*/
public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
    	char[] chars = S.toCharArray();
    	
    	int len = chars.length;
    	shifts[len - 1] = shifts[len - 1] % 26;
    	for(int k = len - 2; k >= 0; k--) {
    		shifts[k] = (shifts[k + 1] + shifts[k]) % 26;
    	}
    	
    	for(int i = 0; i < len; i++) {
    		int newChar = ((chars[i] - 'a') + shifts[i]) % 26;
    		chars[i] = (char)(newChar + 'a');
    	}
    	
    	return new String(chars);
    }
}
