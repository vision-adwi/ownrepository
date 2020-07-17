package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Leetcode#51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
*/
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		positionQueens(n, 0, new ArrayList<>(), result);
		return result;
    }
	
	private void positionQueens(int N, int row, List<List<Integer>> positions, List<List<String>> result) {
		if(positions.size() == N) {
			result.add(stringConversion(positions));
			return;
		}
		for(int column = 0; column < N; column++) {
			if(!isSafePosition(row, column, positions))
				continue;
			
			positions.add(Arrays.asList(row, column));
			positionQueens(N, row + 1, positions, result);
			positions.remove(positions.size() - 1);
		}
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
	
	private List<String> stringConversion(List<List<Integer>> positions) {
		List<String> possibility = new ArrayList<>();
		
		char[] placement;
		for(List<Integer> position : positions) {
			placement = new char[positions.size()];
			Arrays.fill(placement, '.');
			placement[position.get(1)] = 'Q';
			possibility.add(new String(placement));
		}
		
		return possibility;
	}
	
	public static void main(String[] s) {
		NQueens nQueeens = new NQueens();
		System.out.println(nQueeens.solveNQueens(4));
	}

}
