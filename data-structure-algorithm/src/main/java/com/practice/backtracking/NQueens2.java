package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Leetcode#52. N-Queens
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
*/
public class NQueens2 {
	public int totalNQueens(int n) {
		return positionQueens(n, 0, new ArrayList<>(), 0);
    }
	
	private int positionQueens(int N, int row, List<List<Integer>> positions, int count) {
		if(positions.size() == N) {
			count++;
		}
		for(int column = 0; column < N; column++) {
			if(!isSafePosition(row, column, positions))
				continue;
			
			positions.add(Arrays.asList(row, column));
			count = positionQueens(N, row + 1, positions, count);
			positions.remove(positions.size() - 1);
		}
		
		return count;
	}
	
	private boolean isSafePosition(int qRow, int qColumn, List<List<Integer>> positions) {
		for(List<Integer> position : positions) {
			int row = position.get(0);
			int column = position.get(1);
			if(column == qColumn)
				return false;
			
			int diff = qRow - row;
			if(Math.abs(column - qColumn) == diff)
				return false;
		}
		
		return true;
	}

	public static void main(String[] s) {
		NQueens2 nQueeens = new NQueens2();
		System.out.println(nQueeens.totalNQueens(4));
	}

}
