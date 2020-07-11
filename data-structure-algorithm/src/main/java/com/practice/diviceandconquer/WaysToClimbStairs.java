package com.practice.diviceandconquer;
/*
Leetcode#70. Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/		
public class WaysToClimbStairs {
	public int climbStairs(int n) {
		int memory[] = new int[n + 1];
		return climbStairs_td(n, memory);
	}
	
	public int climbStairs_td(int n, int[] memory) {
		if (n <= 1)
			return 1;

		if (memory[n] == 0) {
			int take = climbStairs_td(n - 1, memory);
			int skip = climbStairs_td(n - 2, memory);
			memory[n] = take + skip;
		}

		return memory[n];
	}
	
	public int climbStairs_dc(int n) {
		if(n <= 1)
			return 1;
		
		int take = climbStairs_dc(n - 1);
		int skip = climbStairs_dc(n - 2);
		
		return take + skip;
    }
	
	public int climbStairs_bu(int n) {
		int[] memory = new int[n + 1];
		memory[0] = memory[1] = 1;
		for(int i = 2; i <= n; i++) {
			memory[i] = memory[i -1] + memory[i - 2];
		}
		
		return memory[n];
	}
	
	public static void main(String[] s) {
		int input = 45;
		WaysToClimbStairs ways = new WaysToClimbStairs();
		aop(System.nanoTime(), ways.climbStairs(input), System.nanoTime() );
		aop(System.nanoTime(), ways.climbStairs_bu(input), System.nanoTime() );
		aop(System.nanoTime(), ways.climbStairs_dc(input), System.nanoTime() );
	}
	
	private static void aop(long startTime, Object execution, long endTime) {
		long timeTakenMS = (endTime - startTime) / 1000;
		System.out.println("Time taken: " + timeTakenMS + " microseconds.");
		System.out.println("Result is  : " + execution);
	}
}
