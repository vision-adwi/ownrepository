package com.practice.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Leetcode#1380. Lucky Numbers in a Matrix
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column. 
*/
public class LuckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> lucky = new ArrayList<>();
        if(matrix.length == 0)
            return lucky;
        
        for(int i = 0; i < matrix.length; i++) {
            int min = 0;
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] < matrix[i][min]) {
                    min = j;
                }
            }

            for(int k = 0; k < matrix.length; k++) {
                if(matrix[k][min] > matrix[i][min]) {
                    break;
                } 
                if(k == matrix.length - 1)
                	lucky.add(matrix[i][min]);
            }
        }
        
        return lucky;
    }
}
