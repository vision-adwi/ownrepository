package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Leetcode#1222. Queens That Can Attack the King
On an 8x8 chessboard, there can be multiple Black Queens and one White King.

Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king 
that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.
*/
public class QueensAttackKing {
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[][] queensPresence = new boolean[8][8];
		for(int[] queen : queens) {
			queensPresence[queen[0]][queen[1]] = true;
		}
		
		for(int i = king[0] + 1; i < 8; i++) {
			if(queensPresence[i][king[1]]) {
				result.add(Arrays.asList(i, king[1]));
				break;
			}	
		}
		
		for(int i = king[0] - 1; i >= 0; i--) {
			if(queensPresence[i][king[1]]) {
				result.add(Arrays.asList(i, king[1]));
				break;
			}	
		}
		
		for(int j = king[1] + 1; j < 8; j++) {
			if(queensPresence[king[0]][j]) {
				result.add(Arrays.asList(king[0], j));
				break;
			}	
		}
		
		for(int j = king[1] - 1; j >= 0; j--) {
			if(queensPresence[king[0]][j]) {
				result.add(Arrays.asList(king[0], j));
				break;
			}	
		}
		
		for(int i = king[0] + 1, j = king[1] + 1; i < 8 && j < 8; i++, j++) {
			if(queensPresence[i][j]) {
				result.add(Arrays.asList(i, j));
				break;
			}	
		}
		
		for(int i = king[0] - 1, j = king[1] - 1; i >= 0 && j >= 0; i--, j--) {
			if(queensPresence[i][j]) {
				result.add(Arrays.asList(i, j));
				break;
			}	
		}
		
		for(int i = king[0] + 1, j = king[1] - 1; i < 8 && j >= 0; i++, j--) {
			if(queensPresence[i][j]) {
				result.add(Arrays.asList(i, j));
				break;
			}	
		}
		
		for(int i = king[0] - 1, j = king[1] + 1; i >= 0 && j < 8; i--, j++) {
			if(queensPresence[i][j]) {
				result.add(Arrays.asList(i, j));
				break;
			}	
		}
        
		return result;
    }
	
	public static void main(String[] s) {
		QueensAttackKing chess = new QueensAttackKing();
		System.out.println(chess.queensAttacktheKing(new int[][]{{2,0},{1,6},{3,4},{4,1}}, new int[]{3,5}));
	}

}
