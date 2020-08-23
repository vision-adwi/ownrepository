package com.practice.dynamicprogramming;

import java.util.Arrays;

public class Medium {
	/*
	Leetcode#322. Coin Change
	You are given coins of different denominations and a total amount of money amount. Write a function to compute 
	the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by 
	any combination of the coins, return -1.
	*/
    public int coinChange(int[] coins, int amount) {
        if(coins.length < 1 || amount < 1)
            return 0;
        
        int[] mem = new int[amount + 1];
        Arrays.fill(mem, amount*2);
        
        mem[0] = 0;
        for(int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for(int j = coin; j <= amount; j++){
                mem[j] = Math.min(mem[j], mem[j-coin] + 1);
            }
        }
        
        return mem[amount] == (2*amount) ? -1 : mem[amount];
    }
    
    /*
    Leetcode#300. Longest Increasing Subsequence
    Given an unsorted array of integers, find the length of longest increasing subsequence.
    */
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        
        int[] mem = new int[nums.length];
        Arrays.fill(mem, 1);
        
        int max = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
            max = Math.max(max, mem[i]);
        }
        
    	return max;
    }
    
    /*
    Leetcode#123. Best Time to Buy and Sell Stock III
    Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete at most two transactions.
    */
    public int transaction(int[] prices) {
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
}
