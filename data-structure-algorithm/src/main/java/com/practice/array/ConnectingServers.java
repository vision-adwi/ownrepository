package com.practice.array;
/*
Leetcode#1267
You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that 
cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.
*/
public class ConnectingServers {
	   public int countServers(int[][] grid) {
	        int count = 0;
	        for(int row = 0; row < grid.length; row++) {
	            for(int col = 0; col < grid[0].length; col++) {
	                if(grid[row][col] == 1 && canCommunicate(grid, row, col))
	                    count++;
	            }
	        }
	        
	        return count;
	    }
	    
	    private boolean canCommunicate(int[][] grid, int row, int col) {
	        for(int i = 0; i < grid.length; i++) {
	            if((i != row) && grid[i][col] == 1) {
	                return true;
	            }
	        }
	        
	        for(int j = 0; j < grid[0].length; j++) {
	            if((j != col) && grid[row][j] == 1) {
	                return true;
	            }
	        }
	        
	        return false;
	    }
}
