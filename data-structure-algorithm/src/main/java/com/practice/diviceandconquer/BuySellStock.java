package com.practice.diviceandconquer;

import java.util.stream.IntStream;

/*
Leetcode#121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
*/
public class BuySellStock {
	public int maxProfit_dp(int[] prices) {
		if(prices.length == 0)
			return 0;
		
		int[] mem = new int[prices.length + 1];
		
		mem[prices.length] = 0;
		mem[prices.length - 1] = -prices[prices.length - 1];
		for(int i = prices.length - 2; i >= 0; i--) {
			int diff = prices[i + 1] - prices[i];
			mem[i] = Math.max(mem[i + 1] + diff, diff);
		}
		
		return IntStream.of(mem).max().getAsInt();
	}
	
    public int maxProfit(int[] prices) {
        return buySellProfit(0, prices);
    }
    
    private int buySellProfit(int buyDay, int[] dayPrices) {
    	if(buyDay == dayPrices.length)
    		return 0;

    	int maxProfit = -dayPrices[buyDay];
    	for(int i = buyDay + 1; i < dayPrices.length; i++) {
    		maxProfit = Math.max(maxProfit, dayPrices[i] - dayPrices[buyDay]);
    	}
    	
    	int nextDayBuy = buySellProfit(buyDay + 1, dayPrices);
    	
    	return Math.max(maxProfit, nextDayBuy);
    }
}
