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
    	int[] ascii = new int[S.length()];
    	int index = 0;
    	for(byte c : S.getBytes()) {
    		ascii[index++] = c - 97;
    	}
    	
    	int sum = 0;
    	for(int k = shifts.length - 1; k >= 0; k--) {
    		sum = (sum + shifts[k]) % 26;
    		shifts[k] = sum;
    	}
    	
    	for(int i = 0; i < shifts.length; i++) {
    		int shift = shifts[i];
    		ascii[i] = (ascii[i] + shift) % 26;
    	}
    	
    	char[] chars = new char[S.length()];
    	index = 0;
    	for(int res : ascii) {
    		chars[index++] = (char)(res + 97);
    	}
        
    	return new String(chars);
    }
}
