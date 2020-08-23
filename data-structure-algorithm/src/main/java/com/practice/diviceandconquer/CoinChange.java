 package com.practice.diviceandconquer;

import java.util.Arrays;
/*
Leetcode#322. Coin Change
You are given coins of different denominations and a total amount of money amount. Write a function to compute 
the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by 
any combination of the coins, return -1.
*/
public class CoinChange {
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
}
