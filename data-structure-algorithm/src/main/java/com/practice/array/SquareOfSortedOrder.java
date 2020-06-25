package com.practice.array;
/*
Leetcode#977. Squares of a Sorted Array
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
*/
public class SquareOfSortedOrder {
    public int[] sortedSquares(int[] A) {
    	int len = A.length;
    	int[] square = new int[len];

    	int upper = len - 1;
    	int lower = 0;
    	int n;
    	for(int resultIndex = len - 1; resultIndex >= 0; resultIndex--) {
    		n = (Math.abs(A[upper]) > Math.abs(A[lower])) ? A[upper--] : A[lower++];
    		square[resultIndex] = n * n;
    	}

        
        return square;
    }

}
