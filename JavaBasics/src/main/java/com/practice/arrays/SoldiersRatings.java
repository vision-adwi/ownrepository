package com.practice.arrays;
/*
There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
You have to form a team of 3 soldiers amongst them under the following rules:
Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
*/
public class SoldiersRatings {

	public static void main(String[] args) {
		int[] ranks = {2, 7, 5, 6, 9, 4, 11};
		/*{2, 7, 9}, {2, 7, 11}, {2, 5, 6}, {2, 5, 9}, {2, 5, 11}, {2, 6, 9}, {2, 6, 11}, {2, 9, 11}, {2, 4, 11}
		{7, 9, 11}
		{5, 6, 9}, {5, 6, 11}, {5, 9, 11}
		{6, 9, 11}
		For descending - {7, 5, 4}, {7, 6, 4}*/
		int count = 0;
		for(int i = 0; i < ranks.length; i++) {
			count = teamsAscending(ranks, i, 1, count);
		}
		
		for(int i = 0; i < ranks.length; i++) {
			count = teamsDescending(ranks, i, 1, count);
		}
		System.out.println("Total number of permutations : " + count);
	}
	
	private static int teamsAscending(int[] ranks, int currentIndex, int fill, int count) {
		if(fill == 3) {
			return ++count;
		}
		
		for(int i = currentIndex + 1; i < ranks.length; i++) {
			if(ranks[currentIndex] < ranks[i]) {
				count = teamsAscending(ranks, i, fill + 1, count);
			}
		}
		return count;
	}
	
	private static int teamsDescending(int[] ranks, int currentIndex, int fill, int count) {
		if(fill == 3) {
			return ++count;
		}
		
		for(int i = currentIndex + 1; i < ranks.length; i++) {
			if(ranks[currentIndex] > ranks[i]) {
				count = teamsDescending(ranks, i, fill + 1, count);
			}
		}
		return count;
	}
}
