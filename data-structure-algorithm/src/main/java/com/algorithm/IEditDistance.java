package com.algorithm;
/*
Leetcode#72. Edit Distance {Hard}
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
*/
public interface IEditDistance {
	int minOperations(String source, String destination);

}
