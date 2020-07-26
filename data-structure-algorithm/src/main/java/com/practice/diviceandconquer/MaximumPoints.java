package com.practice.diviceandconquer;

public class MaximumPoints {
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
