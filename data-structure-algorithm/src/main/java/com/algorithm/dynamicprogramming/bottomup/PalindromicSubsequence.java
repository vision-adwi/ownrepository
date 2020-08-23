package com.algorithm.dynamicprogramming.bottomup;

import com.algorithm.IPalindromicSubsequence;

public class PalindromicSubsequence implements IPalindromicSubsequence{
	@Override
	public int lps(String word) {
		int[][] mem = new int[word.length()][word.length()];

		for(int column = 0; column < word.length(); column++) {
			for(int row = word.length() - 1; row >= 0; row--) {
				if( row == column) {
					mem[row][column] = 1;
				}
				else if( row > column) {
					mem[row][column] = 0;
				}
				else {
					if(word.charAt(row) == word.charAt(column)) {
						mem[row][column] = 2 + mem[row + 1][column - 1];
					}
					else {
						mem[row][column] = Math.max(mem[row][column - 1], mem[row + 1][column]);
					}
				}
			}
		}
		
		return mem[0][word.length() - 1];
	}
	
	private int lpsCount(String word, int front, int rear, int[][] mem) {
		if (front > rear) {
			return 0;
		}
		if (front == rear) {
			return 1;
		}

		if (mem[front][rear] == 0) {
			int count1 = 0;
			int count2 = 0;
			if (word.charAt(front) == word.charAt(rear)) {
				count1 = 2 + lpsCount(word, front + 1, rear - 1, mem);
			} else {
				count1 = lpsCount(word, front + 1, rear, mem);
				count2 = lpsCount(word, front, rear - 1, mem);
			}
			mem[front][rear] = Math.max(count1, count2);
		}

		return mem[front][rear];
	}

	public static void main(String[] args) {
		String word = "AMEEWMEA";
		//String word = "ELRMENMET";
		//System.out.println(lpsCount(word, 0, word.length() - 1));
	}

}
