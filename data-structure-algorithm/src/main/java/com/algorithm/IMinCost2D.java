package com.algorithm;
/*
Leetcode#64. Minimum Path Sum
Minimum cost to reach last cell in a 2D matrix.
We are given a 2 D matrix to access each have cost associated to it. Start from top left corner and
end up at right down corner.
Challenge is to find out the minimum cost to reach when movements allowed are down and right only.
*/
 public interface IMinCost2D {
	int minCost(int[][] grid);

}
