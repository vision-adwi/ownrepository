package com.practice.slidingwindow;
/*
Leetcode#424. Longest Repeating Character Replacement
Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.

In one operation, you can choose any character of the string and change it to any other uppercase English character.

Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
*/
public class LongestRepeatCharReplacement {
	public int characterReplacement(String s, int k) {
		int[] frequency = new int[26];
		
		int i = 0;
		int j = 0;
		int maxFrequency = 0;
		while(j < s.length()) {
			char ch = s.charAt(j++);
			frequency[ch - 'A']++;
			maxFrequency = Math.max(maxFrequency, frequency[ch - 'A']);
			
			if(((j - i) - maxFrequency) > k) {
				ch = s.charAt(i++);
				frequency[ch - 'A']--;
			}
			
		}
		
		return (j - i);
	}
    public int characterReplacement_(String s, int k) {
    	char[] chars = s.toCharArray();
    	boolean[] presence = new boolean[26];
    	for(char ch : chars)
    		presence[ch-'A'] = true;
    	
    	int max = 0;
    	for(int i = 0; i < 26 && presence[i]; i++) {
    		int iter = find(chars, (char)(65+i), k);
    		max = Math.max(max, iter);
    	}

        return max;
    }
    
    private int find(char[] chars, char ch, int k) {
    	int i = 0;
    	int j = 0;
		while (j < chars.length) {
			if (chars[j] != ch)
				k--;

			if (k < 0) {
				if (chars[i] != ch) {
					k++;
				}
				i++;
			}

			j++;
		}
		
		return j - i;
    }
    
    public static void main(String[] s) {
    	LongestRepeatCharReplacement repeat = new LongestRepeatCharReplacement();
    	System.out.println(repeat.characterReplacement("AABABBA", 1));
    }

}
