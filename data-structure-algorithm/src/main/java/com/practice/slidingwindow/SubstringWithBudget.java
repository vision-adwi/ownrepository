package com.practice.slidingwindow;
/*
Leetcode#1208. Get Equal Substrings Within Budget
You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, 
the absolute difference between the ASCII values of the characters.
You are also given an integer maxCost.
Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.
If there is no substring from s that can be changed to its corresponding substring from t, return 0.
*/
public class SubstringWithBudget {
	public int equalSubstring(String s, String t, int maxCost) {
		int i = 0;
		int j = 0;
		
		int sum = 0;
		int max = 0;
		while(j < s.length()) {
			sum = sum + Math.abs(s.charAt(j) - t.charAt(j++));
			while(sum > maxCost) {
				sum = sum - Math.abs(s.charAt(i) - t.charAt(i++));
			}
			
			max = Math.max(max, (j - i));
		}
		return max;
	}
	
	public int equalSubstring_(String s, String t, int maxCost) {
		int[] diffs = new int[s.length()];
		for (int k = 0; k < diffs.length; k++) {
			diffs[k] = Math.abs(s.charAt(k) - t.charAt(k));
		}

		int i = 0;
		int j = 0;
		int sum = 0;
		int max = 0;
		while (j < diffs.length) {
			if ((sum + diffs[j]) <= maxCost) {
				sum = sum + diffs[j++];
				max = Math.max(max, (j - i));
			} else if (i < j) {
				sum = sum - diffs[i++];
			} else {
				i++; j++;
			}
		}

		return max;
	}
    
    public static void main(String[] s) {
    	SubstringWithBudget subs = new SubstringWithBudget();
    	
    }
}
