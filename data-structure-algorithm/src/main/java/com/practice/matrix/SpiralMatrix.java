package com.practice.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result = new ArrayList<>();
    	if(matrix.length == 0)
    		return result;
    	
    	int elements = matrix.length * matrix[0].length;

    	int right = matrix[0].length;
    	int bottom = matrix.length;
    	int left = 0;
    	int top = 1;
    	
    	int row = -1, column = -1; 
		while (true) {
			row++; column++;
			while (column < right) 
				result.add(matrix[row][column++]);

			if(result.size() == elements) break;
			
			column--; row++;
			while (row < bottom) 
				result.add(matrix[row++][column]);
			
			if(result.size() == elements) break;
			
			row--; column--;
			while (column >= left) 
				result.add(matrix[row][column--]);

			if(result.size() == elements) break;
			
			column++; row--;
			while (row >= top) 
				result.add(matrix[row--][column]);
			
			if(result.size() == elements) break;

			right--; bottom--; left++; top++;
		}

    	return result;
    }
}
