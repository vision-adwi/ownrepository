package com.algorithm.dynamicprogramming.bottomup;

import com.algorithm.IPalindromicSubstring;

public class PalindromicSubstring implements IPalindromicSubstring{

	@Override
	public int maxSize(String s) {
		int[][] mem = new int[s.length()][s.length()];
		
		for(int column = 0; column < s.length(); column++) {
			for(int row = s.length() - 1; row >= 0; row--) {
				if(row == column) {
					mem[row][column] = 1;
				}
				else if(row > column) {
					mem[row][column] = 0;
				}
				else {
					int l1 = 0;
					if(s.charAt(row) == s.charAt(column)) {
						if(mem[row + 1][column - 1] == column - row - 1) {
							l1 = 2 + mem[row + 1][column - 1];
						}
					}
					
					mem[row][column] =  Math.max(l1, Math.max(mem[row + 1][column], mem[row][column - 1]));
				}
			}
		}
		

		return mem[0][s.length() - 1];
	}

}
