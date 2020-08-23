package com.practice.diviceandconquer;
/*
Leetcode#123. Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
*/
public class BuySellStock3 {
    private int transaction_dp(int[] prices) {
    	int len = prices.length;
    	if(len <= 1)
    		return 0;
    	int k = 2;
    	int[] target;
    	
    	int[] source = new int[len];
    	
    	while(k-- > 0) {
    		target = new int[len];
    		for(int j = 1; j < len; j++) {
    			int sellPrice = prices[j];
    			
    			int trxMax = 0;
    			for(int t = j - 1; t >= 0; t--) {
    				trxMax = Math.max(trxMax, (sellPrice - prices[t]) + source[t]);
    			}
    			
    			target[j] = Math.max(target[j - 1], trxMax);
    		}
    		
    		source = target;
    	}
    	
    	return source[len - 1];
    }
    
    public int maxProfit(int[] prices) {
    	return transaction(prices, 0, -1, 2);
    }

	private int transaction(int[] prices, int day, int buyAmount, int trxLeft) {
		if(trxLeft <= 0)
			return 0;
		
		if (day >= prices.length) {
			return buyAmount > -1 ? -buyAmount : 0;
		}

		if (buyAmount > -1) {
			int x1 = (prices[day] - buyAmount) + transaction(prices, day + 1, -1, trxLeft - 1);
			int x2 = transaction(prices, day + 1, buyAmount, trxLeft);
			
			return Math.max(x1, x2);
		} else {
			int t1 = transaction(prices, day + 1, prices[day], trxLeft);
			int t2 = transaction(prices, day + 1, -1, trxLeft);
			
			return Math.max(t1, t2);
		}	
	}
    
    
}
