package com.practice.diviceandconquer;
/*
Leetcode#122. Best Time to Buy and Sell Stock II
Say you have an array prices for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(i.e., buy one and sell one share of the stock multiple times).
*/
public class BuySellStock2 {
	//Valley-peak appraoch
	public int maxProfit_dp(int[] prices) {
		int min = 0, max = 0;
		int profit = 0;
		
		int day = 1;
		while(true) {
			while((day < prices.length) && (prices[day - 1] > prices[day])) {
				++day;
			}
			if(day == prices.length)
				break;
			
			min = prices[day - 1];
			
			while((day < prices.length - 1) && (prices[day] < prices[day + 1])) {
				++day;
			}
			max = prices[day];
			
			profit = profit + (max - min);
			
			day = day + 2;
			if(day >= prices.length)
				break;
		}
		
		
        return profit;
    }
	
	public int maxProfit(int[] prices) {
        return transaction(prices, 0, -1);
    }

	private int transaction(int[] prices, int day, int buyAmount) {
		if (day >= prices.length) {
			return buyAmount > -1 ? -buyAmount : 0;
		}

		if (buyAmount > -1) {
			int x1 = (prices[day] - buyAmount) + transaction(prices, day + 1, -1);
			int x2 = transaction(prices, day + 1, buyAmount);
			
			return Math.max(x1, x2);
		} else {
			int t1 = transaction(prices, day + 1, prices[day]);
			int t2 = transaction(prices, day + 1, -1);
			
			return Math.max(t1, t2);
		}	
	}
}
