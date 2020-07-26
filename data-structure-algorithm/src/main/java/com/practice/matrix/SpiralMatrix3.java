package com.practice.matrix;
/*
Leetcode#885. Spiral Matrix III
*/
public class SpiralMatrix3 {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
    	int[][] coordinates = new int[R*C][2];
    	int index = 0;
    	
    	int right = c0 + 1;
    	int bottom = r0 + 1;
    	int left = c0 - 1;
    	int top = r0 - 1;
    	
    	int row = r0;
    	int column = c0 - 1;
    	while(true) {
      		while(++column <= right) {
    			if(row >= 0 && row < R && column >= 0 && column < C)
    				coordinates[index++] = new int[] {row, column};
    		}
    		if(index == coordinates.length) break;
    		
    		--column;
    		while(++row <= bottom) {
    			if(row >= 0 && row < R && column >= 0 && column < C)
    				coordinates[index++] = new int[] {row, column};
    		}
    		if(index == coordinates.length) break;
    		
    		--row;
    		while(--column >= left) {
    			if(row >= 0 && row < R && column >= 0 && column < C)
    				coordinates[index++] = new int[] {row, column};
    		}
    		if(index == coordinates.length) break;
    		
    		++column;   		
    		while(--row >= top) {
    			if(row >= 0 && row < R && column >= 0 && column < C)
    				coordinates[index++] = new int[] {row, column};
    		}
    		if(index == coordinates.length) break;
    		
    		++row;
    		
    		right++; bottom++; left--; top--;
    	}
        
    	return coordinates;
    }
    
    
    public static void main(String[] s) {
    	SpiralMatrix3 matrix = new SpiralMatrix3();
    	matrix.spiralMatrixIII(1, 4, 0, 0);
    }
    
    
    
    
	public int[][] generateMatrix(int n) {	
    	int[][] matrix = new int[n][n];
    	int num = 1;

    	int right = n;
    	int bottom = n;
    	int left = 0;
    	int top = 1;
    	
    	int row = -1, column = -1; 
		while (true) {
			row++; column++;
			while (column < right) 
				matrix[row][column++] = num++;

			if(num > (n*n)) break;
			
			column--; row++;
			while (row < bottom) 
				matrix[row++][column] = num++;
			
			if(num > (n*n)) break;
			
			row--; column--;
			while (column >= left) 
				matrix[row][column--] = num++;

			if(num > (n*n)) break;
			
			column++; row--;
			while (row >= top) 
				matrix[row--][column] = num++;
			
			if(num > (n*n)) break;

			right--; bottom--; left++; top++;
		}

    	return matrix;
    }
}
