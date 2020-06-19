package com.practice.diviceandconquer;

public class MaxWaysToReach{

	public int waysToReach(int row, int column, int count) {
		//terminal condition
		if((row == 0) && (column == 0)){
			return count + 1;
		}
		if((row == -1) || (column == -1)) {
			return count;
		}

		count = waysToReach(row, column - 1, count);
		count = waysToReach(row - 1, column, count);
		
		return count;
	}
	
	public static void main(String[] s) {
		int row = 4, column = 5;
		MaxWaysToReach maxWays = new MaxWaysToReach();
		
		int ways = maxWays.waysToReach(row - 1, column - 1, 0);
		System.out.println(ways);
	}

}
