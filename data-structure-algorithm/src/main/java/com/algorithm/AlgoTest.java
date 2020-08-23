package com.algorithm;

import com.practice.diviceandconquer.SubsetSum;

public class AlgoTest {
	private static final String DC = "Divide and Concquer";
	private static final String MEM = "Memoization";
	private static final String DP = "Dynamic Programming";

	public static void main(String[] args) {
		//fibonacciNumber();
		//numberFactorAlgo();
		//houseThiefAlgo();
		stringToString();
		//longestCommonSubsequence();
		//longestPalindromicSubsequence();
		//longestPalindromicSubstring();
		//minCostArray();
		
		//subsetSumTest();

		//zeroOneKnapsackTest();
	}
	
	private static void fibonacciNumber() {
		int testNumber = 50;
		
		IFibonacciNumber fibonacci;
		
		fibonacci = new com.algorithm.dynamicprogramming.topdown.FibonacciNumber();
		aop(System.nanoTime(), fibonacci.calculate(testNumber), System.nanoTime(), MEM );

		fibonacci = new com.algorithm.dynamicprogramming.bottomup.FibonacciNumber();
		aop(System.nanoTime(), fibonacci.calculate(testNumber), System.nanoTime(), DP );

		fibonacci = new com.algorithm.divideandconquer.FibonacciNumber();
		aop(System.nanoTime(), fibonacci.calculate(testNumber), System.nanoTime(), DC );
	}
	
	private static void numberFactorAlgo() {
		int testNumber = 50;

		INumberFactor numberFactor;
		
		numberFactor = new com.algorithm.dynamicprogramming.topdown.NumberFactor();
		aop(System.nanoTime(), numberFactor.solve(testNumber), System.nanoTime(), MEM );

		numberFactor = new com.algorithm.dynamicprogramming.bottomup.NumberFactor();
		aop(System.nanoTime(), numberFactor.solve(testNumber), System.nanoTime(), DP );

		numberFactor = new com.algorithm.divideandconquer.NumberFactor();
		aop(System.nanoTime(), numberFactor.solve(testNumber), System.nanoTime(), DC );
	}
	
	private static void houseThiefAlgo() {
		int[] houses = {6, 7, 1, 30, 8, 2, 4, 3, 19, 44, 8, 33, 1, 2, 99, 67};
		
		IHouseThief houseThief;
		
		houseThief = new com.algorithm.dynamicprogramming.topdown.HouseThief();
		aop(System.nanoTime(), houseThief.maxStealth(houses), System.nanoTime(), MEM );
		
		houseThief = new com.algorithm.dynamicprogramming.bottomup.HouseThief();
		aop(System.nanoTime(), houseThief.maxStealth(houses), System.nanoTime(), DP );
		
		houseThief = new com.algorithm.divideandconquer.HouseThief();
		aop(System.nanoTime(), houseThief.maxStealth(houses), System.nanoTime(), DC );
	}
	
	private static void stringToString() {
		String s1 = "horse";//"variablevariable";
		String s2 = "ros";//"finalizevariable";
		
		IEditDistance stringToString;
		
		stringToString = new com.algorithm.dynamicprogramming.topdown.EditDistance();
		aop(System.nanoTime(), stringToString.minOperations(s1, s2), System.nanoTime(), MEM );
		
		stringToString = new com.algorithm.dynamicprogramming.bottomup.EditDistance();
		aop(System.nanoTime(), stringToString.minOperations(s1, s2), System.nanoTime(), DP );
		
		stringToString = new com.algorithm.divideandconquer.EditDistance();//
		aop(System.nanoTime(), stringToString.minOperations(s1, s2), System.nanoTime(), DC );
	}
	
	private static void longestCommonSubsequence() {
		String s1 = "elbandazole";
		String s2 = "elephantobia";
		
		ICommonSubsequence subsequence;
		
		subsequence = new com.algorithm.dynamicprogramming.topdown.CommonSubsequence();
		aop(System.nanoTime(), subsequence.lcs(s1, s2), System.nanoTime(), MEM );
		
		subsequence = new com.algorithm.dynamicprogramming.bottomup.CommonSubsequence();
		aop(System.nanoTime(), subsequence.lcs(s1, s2), System.nanoTime(), DP );
		
		subsequence = new com.algorithm.divideandconquer.CommonSubsequence();//
		aop(System.nanoTime(), subsequence.lcs(s1, s2), System.nanoTime(), DC );
	}
	
	private static void longestPalindromicSubsequence() {
		String s = "AMEEWMEA";
		//String s = "ELRMENMET";
		//String s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhp";

		IPalindromicSubsequence palindromicSubsequence;
		
		palindromicSubsequence = new com.algorithm.dynamicprogramming.topdown.PalindromicSubsequence();
		aop(System.nanoTime(), palindromicSubsequence.lps(s), System.nanoTime(), MEM );
		
		palindromicSubsequence = new com.algorithm.dynamicprogramming.bottomup.PalindromicSubsequence();
		aop(System.nanoTime(), palindromicSubsequence.lps(s), System.nanoTime(), DP );
		
		palindromicSubsequence = new com.algorithm.divideandconquer.PalindromicSubsequence();
		aop(System.nanoTime(), palindromicSubsequence.lps(s), System.nanoTime(), DC );
	}
	
	private static void longestPalindromicSubstring() {
		String s = "oranggoutoro";

		IPalindromicSubstring palindromicSubstring;
		
		palindromicSubstring = new com.algorithm.dynamicprogramming.topdown.PalindromicSubstring();
		aop(System.nanoTime(), palindromicSubstring.maxSize(s), System.nanoTime(), MEM );
		
		palindromicSubstring = new com.algorithm.dynamicprogramming.bottomup.PalindromicSubstring();
		aop(System.nanoTime(), palindromicSubstring.maxSize(s), System.nanoTime(), DP );
		
		palindromicSubstring = new com.algorithm.divideandconquer.PalindromicSubstring();
		aop(System.nanoTime(), palindromicSubstring.maxSize(s), System.nanoTime(), DC );
	}
	
	private static void minCostArray() {
		int[][] grid = {{4,	7,	8,	6,	4},
						{6,	7,	3,	9,	2},
						{3,	8,	1,	2,	4},
						{7,	1,	7,	3,	7},
						{2,	9,	8,	9,	3}};
		
		IMinCost2D minCost2D;
		
		minCost2D = new com.algorithm.dynamicprogramming.topdown.MinCostArray();
		aop(System.nanoTime(), minCost2D.minCost(grid), System.nanoTime(), MEM );
		
		minCost2D = new com.algorithm.dynamicprogramming.bottomup.MinCostArray();
		aop(System.nanoTime(), minCost2D.minCost(grid), System.nanoTime(), DP );
		
		minCost2D = new com.algorithm.divideandconquer.MinCostArray();
		aop(System.nanoTime(), minCost2D.minCost(grid), System.nanoTime(), DC );
		
		
	}
	
	
	private static void zeroOneKnapsackTest() {
		int[] profits = {31, 26, 72, 17, 31, 26, 72, 17};
		int[] weights = {3, 1, 5, 2, 3, 1, 5, 2};
		
		IZeroOneKnapsack zeroOneKnapsack;
		zeroOneKnapsack = new com.algorithm.dynamicprogramming.topdown.ZeroOneKnapsack(); 
		aop(System.nanoTime(), zeroOneKnapsack.maximize(weights, profits, 14), System.nanoTime(), MEM );
		
		zeroOneKnapsack = new com.algorithm.divideandconquer.ZeroOneKnapsack(); 
		aop(System.nanoTime(), zeroOneKnapsack.maximize(weights, profits, 14), System.nanoTime(), DC );

	}
	

	

	
	private static void subsetSumTest() {
		int[] data = {7, 6, 9, 5, 19, 33, 104,7, 6, 9, 5, 19, 33, 104};
		
		SubsetSum subset = new SubsetSum();
		long startTime = System.nanoTime();
		System.out.println("Is subset sum(49) - " + subset.isSubsetSum(data, 49));
		long endTime = System.nanoTime();
		long timeTakenMS = (endTime - startTime) / 1000;
		System.out.println("Time taken: " + timeTakenMS + " microseconds.");
	}


	private static void aop(long startTime, Object execution, long endTime, String type) {
		System.out.println(type);
		long timeTakenMS = (endTime - startTime) / 1000;
		System.out.println("Time taken: " + timeTakenMS + " microseconds.");
		System.out.println("Result is  : " + execution);
	}

}
