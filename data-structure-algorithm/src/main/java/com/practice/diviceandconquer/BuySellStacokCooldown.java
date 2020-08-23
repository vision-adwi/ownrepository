package com.practice.diviceandconquer;
/*
Leetcode#309. Best Time to Buy and Sell Stock with Cooldown
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
*/
public class BuySellStacokCooldown {
	public int maxProfit_dp(int[] prices, int fee) {
		int length = prices.length;
		if(length <= 1)
			return 0;
		
		int[][] mem = new int[2][prices.length];
		mem[0][0] = 0;
		mem[1][0] = -prices[0];
		if(length >= 2) {
			mem[0][1] = Math.max(mem[0][0], mem[1][0] + prices[1]);
			mem[1][1] = Math.max(mem[1][0], mem[0][0] - prices[1]);
		}

		for(int i = 2; i < prices.length; i++) {
			mem[0][i] = Math.max(mem[0][i-1], mem[1][i-1] + prices[i]); 
			mem[1][i] = Math.max(mem[1][i-1], mem[0][i-2] - prices[i]);
		}
		
		return mem[0][prices.length-1];
    }
	
	public int maxProfit(int[] prices) {
        return transaction(prices, 0, -1);
    }

	private int transaction(int[] prices, int day, int buyAmount) {
		if (day >= prices.length) {
			return buyAmount > -1 ? -buyAmount : 0;
		}

		if (buyAmount > -1) {
			int x1 = (prices[day] - buyAmount) + transaction(prices, day + 2, -1);
			int x2 = transaction(prices, day + 1, buyAmount);
			
			return Math.max(x1, x2);
		} else {
			int t1 = transaction(prices, day + 1, prices[day]);
			int t2 = transaction(prices, day + 1, -1);
			
			return Math.max(t1, t2);
		}	
	}
}
