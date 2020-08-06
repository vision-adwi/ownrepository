package com.practice.heap;

import java.util.PriorityQueue;
/*
Leetcode#378. Kth Smallest Element in a Sorted Matrix
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.
*/
public class KSmallestInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Cell> queue = new PriorityQueue<>((e1, e2) -> e1.value().compareTo(e2.value()));
		
		for(int col = 0; col < matrix[0].length; col++)
			queue.offer(new Cell(matrix, 0, col));
		
		Cell cell = null;
		while(k-- > 0) {
			cell = queue.poll();
			if(cell.row < matrix.length - 1)
				queue.offer(new Cell(matrix, cell.row + 1, cell.column));
		}
		
		return cell.value();
	}
}

class Cell {
	int[][] matrix;
	int row;
	int column;
	
	Cell(int[][] mat, int r, int c) {
		matrix = mat;
		row = r;
		column = c;
	}
	
	Integer value() {
		return matrix[row][column];
	}
	
	int row() {
		return row;
	}
	
	int column() {
		return column;
	}
}
