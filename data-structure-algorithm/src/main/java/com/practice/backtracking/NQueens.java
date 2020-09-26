package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
Leetcode#51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
*/
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		position(n, new boolean[n][n], 0, result);
		return result;
    }

	private void position(int N, boolean[][] board, int row, List<List<String>> result) {
		if(row >= N) {
			result.add(toString(board));
			return;
		}
		
		for(int col = 0; col < N; col++) {
			if(row > 0 && !isSafe(board, row - 1, col))
				continue;
			
			board[row][col] = true;
			position(N, board, row + 1, result);
			board[row][col] = false;
		}		
	}
	
	private boolean isSafe(boolean[][] board, int row, int col) {
		int j = 1;
		while(row >= 0) {
			if(board[row][col]) 
				return false;
			if((col + j) < board.length && board[row][col + j])
				return false;
			if((col - j) >= 0 && board[row][col - j])
				return false;

			row--; j++;
		}
		
		return true;
	}
	
	private List<String> toString(boolean[][] board) {
		List<String> position = new LinkedList<>();
		StringBuilder sb;
		for(boolean[]row : board) {
			sb = new StringBuilder();
			for(boolean col : row) {
				if(col)
					sb.append("Q");
				else
					sb.append(".");
			}
			position.add(sb.toString());
		}
		
		return position;
	}

	public static void main(String[] s) {
		NQueens nQueeens = new NQueens();
		System.out.println(nQueeens.solveNQueens(4));
	}

}
