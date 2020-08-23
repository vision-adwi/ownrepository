package com.practice.diviceandconquer;
/*
Leetcode#714. Best Time to Buy and Sell Stock with Transaction Fee
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; 
and a non-negative integer fee representing a transaction fee.
You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. 
You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
Return the maximum profit you can make.
*/
public class BuySellStockWithFee {
	public int maxProfit_dp1(int[] prices, int fee) {
		int sell = 0;
		int buy = -(prices[0] + fee);
		for(int i = 1; i < prices.length; i++) {
			sell = Math.max(sell, buy + prices[i]);
			buy = Math.max(buy, sell - (prices[i] + fee));
		}
		
		return sell;
    }
	
	public int maxProfit_dp(int[] prices, int fee) {
		int[][] mem = new int[2][prices.length];
		
		mem[0][0] = 0;
		mem[1][0] = -(prices[0] + fee);
		for(int i = 1; i < prices.length; i++) {
			mem[0][i] = Math.max(mem[0][i-1], mem[1][i-1] + prices[i]); 
			mem[1][i] = Math.max(mem[1][i-1], mem[0][i-1] - (prices[i] + fee));
		}
		
		return mem[0][prices.length-1];
    }

	public int maxProfit(int[] prices, int fee) {
        return transaction(prices, 0, -1, fee);
    }
	
	private int transaction(int[] prices, int day, int buyAmount, int fee) {
		if (day == prices.length) {
			return buyAmount > -1 ? -(buyAmount + fee) : 0;
		}

		if (buyAmount > -1) {
			int x1 = (prices[day] - (buyAmount + fee)) + transaction(prices, day + 1, -1, fee);
			int x2 = transaction(prices, day + 1, buyAmount, fee);
			
			return Math.max(x1, x2);
		} else {
			int t1 = transaction(prices, day + 1, prices[day], fee);
			int t2 = transaction(prices, day + 1, -1, fee);
			
			return Math.max(t1, t2);
		}	
	}

}
