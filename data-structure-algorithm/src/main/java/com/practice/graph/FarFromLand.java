package com.practice.graph;

public class FarFromLand {
	public int maxDistance(int[][] grid) {
		int maxDistance = -1;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 0) {
					int dis = explore(grid, i, j, Integer.MAX_VALUE, 0);
					dis = (dis == Integer.MAX_VALUE) ? -1 : dis;
					maxDistance = Math.max(maxDistance, dis);
				}
			}
		}
        
		return maxDistance;
    }
	
	private int explore(int[][] grid, int row, int col, int threshold, int distance) {
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1) {
			return threshold;
		}
		
		if(distance >= threshold)
			return threshold;
		
		if(grid[row][col] == 1)
			return distance;
		
		grid[row][col] = -1;
		threshold = explore(grid, row - 1, col, threshold, distance + 1);
		threshold = explore(grid, row, col - 1, threshold, distance + 1);
		threshold = explore(grid, row + 1, col, threshold, distance + 1);
		threshold = explore(grid, row, col + 1, threshold, distance + 1);
		grid[row][col] = 0;
		
		return threshold;
	}
	
	public static void main(String[] s) {
		FarFromLand far = new FarFromLand();
		far.maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}});
	}

}
