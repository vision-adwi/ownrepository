package com.algorithm.dynamicprogramming.bottomup;

import com.algorithm.IStringToString;

public class StringToString implements IStringToString{
	@Override
	public int minOperations(String source, String destination) {
		int sLength = source.length();
		int dLength = destination.length();
		
		int[][] dp = new int[source.length() + 1][destination.length() + 1];
		for(int dIndex = 0; dIndex < destination.length(); dIndex++) {
			dp[source.length()][dIndex] = destination.length() - dIndex;
		}
		for(int sIndex = 0; sIndex < source.length(); sIndex++) {
			dp[sIndex][destination.length()] = source.length() - sIndex;
		}
		
		for(int i = sLength; i > 0; i--) {
			for(int j = dLength; j > 0; j--) {
				if(source.charAt(sLength - i) == destination.charAt(dLength - j)) {
					dp[i - 1][j - 1] = dp[i][j];
				}
				else {
					dp[i - 1][j - 1] = 1 + Math.min(dp[i][j], (Math.min(dp[i][j - 1], dp[i - 1][j])));
				}
			}
		}
		
		
		return dp[0][0];
	}
}
