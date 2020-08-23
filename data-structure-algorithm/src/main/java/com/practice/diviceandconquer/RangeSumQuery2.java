package com.practice.diviceandconquer;

public class RangeSumQuery2 {
    int[][] mem;
    public RangeSumQuery2(int[][] matrix) {
        if(matrix.length > 0) {
            mem = new int[matrix.length + 1][matrix[0].length + 1];
            for(int i = 1; i <= matrix.length; i++) {
                for(int j = 1; j <= matrix[0].length; j++) {
                    mem[i][j] = mem[i-1][j] + mem[i][j-1] - mem[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(mem == null)
            return 0;
        return mem[row2+1][col2+1] - mem[row1][col2+1] - mem[row2+1][col1] + mem[row1][col1];
    }
   
    public static void main(String[] s) {
    	int[][] matrix = {
    			  {3, 0, 1, 4, 2},
    			  {5, 6, 3, 2, 1},
    			  {1, 2, 0, 1, 5},
    			  {4, 1, 0, 1, 7},
    			  {1, 0, 3, 0, 5}
    			};
    	RangeSumQuery2 query = new RangeSumQuery2(matrix);	
    	System.out.println(query.sumRegion(1, 1, 3, 3));
    }
}
