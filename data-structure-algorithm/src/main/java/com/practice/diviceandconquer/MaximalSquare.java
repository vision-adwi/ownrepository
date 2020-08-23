package com.practice.diviceandconquer;
/*
Leetcode#221. Maximal Square
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
*/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int max = 0;
        int[][] mem = new int[row][col];
        for(int i = 0; i < col; i++) {
            mem[0][i] = Character.getNumericValue(matrix[0][i]);
            max = Math.max(max, mem[0][i]);
        }
        
        for(int i = 0; i < row; i++) {
            mem[i][0] = Character.getNumericValue(matrix[i][0]);
            max = Math.max(max, mem[i][0]);
        }
        
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] != '0') {
                    mem[i][j] = Math.min(Math.min(mem[i-1][j],mem[i-1][j-1]), mem[i][j-1]) + 1;
                }
                max = Math.max(max, mem[i][j]);
            }
        }
        
        return max * max;
    }

}
