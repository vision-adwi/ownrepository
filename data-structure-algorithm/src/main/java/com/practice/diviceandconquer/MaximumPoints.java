package com.practice.diviceandconquer;
/*
Leetcode#1423. Maximum Points You Can Obtain from Cards

There are several cards arranged in a row, and each card has an associated number of points The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
*/		
public class MaximumPoints {
	public int maxScore_dp(int[] cardPoints, int k) {
        if(cardPoints.length < 1 || k < 1)
            return 0;
        
        int[] fwd_sum = new int[k+1];
        int[] bck_sum = new int[k+1];

        for(int i = 1; i <= k; i++) {
            fwd_sum[i] = fwd_sum[i - 1] + cardPoints[i - 1];
        }

        int len = cardPoints.length - 1;
        for(int i = k - 1; i >= 0; i--) {
            bck_sum[i] = bck_sum[i + 1] + cardPoints[len--];
        }
        
        int max = 0;
        for(int i = 0; i <= k; i++) {
            max = Math.max(max, fwd_sum[i] + bck_sum[i]);
        }
        
        return max;
    }
	
	public int maxScore(int[] cardPoints, int k) {
		int[][] mem = new int[k][k];
		return scoreCalculation_mem(cardPoints, k, 0, cardPoints.length - 1, mem);
    }

	private int scoreCalculation_dc(int[] cards, int remaining, int start, int end) {
		if(remaining <= 0)
			return 0;
		
		int pickFirst = cards[start] + scoreCalculation_dc(cards, remaining - 1, start + 1, end);
		int pickLast = cards[end] + scoreCalculation_dc(cards, remaining - 1, start, end - 1);
		
		return Math.max(pickLast, pickFirst);			
	}
	
	private int scoreCalculation_mem(int[] cards, int remaining, int start, int end, int[][] mem) {
		if (remaining <= 0)
			return 0;

		int offset = mem.length - (cards.length - end);
		if (mem[start][offset] == 0) {
			int pickFirst = cards[start] + scoreCalculation_mem(cards, remaining - 1, start + 1, end, mem);
			int pickLast = cards[end] + scoreCalculation_mem(cards, remaining - 1, start, end - 1, mem);

			mem[start][offset] = Math.max(pickLast, pickFirst);
		}

		return mem[start][offset];
	}
	
	public static void main(String[] s) {
		MaximumPoints points = new MaximumPoints();
		System.out.println(points.maxScore(new int[]{1,2,3,4,5,6,1}, 3));
	}
}
