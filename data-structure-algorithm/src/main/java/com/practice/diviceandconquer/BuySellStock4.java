package com.practice.diviceandconquer;
/*
Leetcode#188. Best Time to Buy and Sell Stock IV
Say you have an array for which the i-th element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
*/
public class BuySellStock4 {
    public int maxProfit(int k, int[] prices) {
    	return transaction(prices, 1, 0, k);
    }
    
    private int transaction_dp(int k, int[] prices) {
    	int len = prices.length;
    	if(len <= 1 || k < 1)
    		return 0;
    	
    	if(k > (len / 2)) {
    		int profit = 0;
    		for(int i = 0; i < len - 1; i++) {
    			if(prices[i] < prices[i + 1])
    				profit += prices[i + 1] - prices[i];
    		}
    		return profit;
    	}

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

	private int transaction(int[] prices, int day, int threshold, int trxLeft) {
		if(trxLeft <= 0)
			return 0;
		
		if( day >= prices.length)
			return 0;
		
		
		int profit = 0;
		for(int i = day - 1; i >= threshold; i--) {
			profit = Math.max(profit, prices[day] - prices[i]);
		}
		
		int trx = profit + transaction(prices, day + 2, day + 1, trxLeft - 1);
		int noTrx = transaction(prices, day + 1, threshold, trxLeft);
		
		return Math.max(trx, noTrx);
	}
    
    
}
