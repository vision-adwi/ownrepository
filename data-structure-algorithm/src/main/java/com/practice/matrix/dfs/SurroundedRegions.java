package com.practice.matrix.dfs;
/*
Leetcode#130. Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
*/
public class SurroundedRegions {
    public void solve(char[][] board) {
    	if(board.length == 0)
            return;
    	
    	int rows = board.length;
    	int cols = board[0].length;
    	
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < cols; j++) {
    			if(board[i][j] == 'O') {
    				if(searchAndReplace(board, i, j, 'O', 'P')) {
    					searchAndReplace(board, i, j, 'P', 'X');
    				}
    			}
    		}
    	}
    	
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < cols; j++) {
    			if(board[i][j] == 'P') {
    				board[i][j] = 'O';
    			}
    		}
    	}
        
    }
    
    private boolean searchAndReplace(char[][] board, int i, int j, char check, char replace) {
    	if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
    		return false;
    	
    	if(board[i][j] != check)
    		return true;
    	
    	board[i][j] = replace;
    	
    	boolean up = searchAndReplace(board, i - 1, j, check, replace);
    	boolean down = searchAndReplace(board, i + 1, j, check, replace);
    	boolean left = searchAndReplace(board, i, j - 1, check, replace);
    	boolean right = searchAndReplace(board, i, j + 1, check, replace);
    	
    	return up && down && left && right;
    }

}
