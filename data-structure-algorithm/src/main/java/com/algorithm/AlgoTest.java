package com.algorithm;

public class AlgoTest {

	public static void main(String[] args) {
		//numberFactorAlgo();
		//houseThiefAlgo();
		//minCostArray();
		stringToString();

	}
	
	private static void numberFactorAlgo() {
		int testNumber = 48;

		INumberFactor numberFactor;
		numberFactor = new com.algorithm.dynamicprogramming.topdown.NumberFactor();
		aop(System.nanoTime(), numberFactor.solve(testNumber), System.nanoTime() );

		numberFactor = new com.algorithm.dynamicprogramming.bottomup.NumberFactor();
		aop(System.nanoTime(), numberFactor.solve(testNumber), System.nanoTime() );

		numberFactor = new com.algorithm.divideandconquer.NumberFactor();
		aop(System.nanoTime(), numberFactor.solve(testNumber), System.nanoTime() );
	}
	
	private static void houseThiefAlgo() {
		int[] houses = {6, 7, 1, 30, 8, 2, 4, 3};
		
		IHouseThief houseThief;
		houseThief = new com.algorithm.dynamicprogramming.topdown.HouseThief();
		aop(System.nanoTime(), houseThief.maxStealth(houses), System.nanoTime() );
		
		houseThief = new com.algorithm.dynamicprogramming.bottomup.HouseThief();
		aop(System.nanoTime(), houseThief.maxStealth(houses), System.nanoTime() );
		
		houseThief = new com.algorithm.divideandconquer.HouseThief();
		aop(System.nanoTime(), houseThief.maxStealth(houses), System.nanoTime() );
	}
	
	private static void minCostArray() {
		int[][] grid = {{4,	7,	8,	6,	4},
						{6,	7,	3,	9,	2},
						{3,	8,	1,	2,	4},
						{7,	1,	7,	3,	7},
						{2,	9,	8,	9,	3}};
		
		IMinCost2D minCost2D;
		minCost2D = new com.algorithm.divideandconquer.MinCostArray();
		aop(System.nanoTime(), minCost2D.minCost(grid, grid.length - 1, grid[0].length - 1), 
				System.nanoTime() );
	}
	
	private static void stringToString() {
		String s1 = "variablevariable";
		String s2 = "finalizevariable";
		
		IStringToString stringToString;
		stringToString = new com.algorithm.dynamicprogramming.topdown.StringToString();//
		aop(System.nanoTime(), stringToString.minOperations(s1, s2), System.nanoTime() );
		
		stringToString = new com.algorithm.divideandconquer.StringToString();//
		aop(System.nanoTime(), stringToString.minOperations(s1, s2), System.nanoTime() );
	}

	private static void aop(long startTime, Object execution, long endTime) {
		long timeTakenMS = (endTime - startTime) / 1000;
		System.out.println("Time taken: " + timeTakenMS + " microseconds.");
		System.out.println("Result is  : " + execution);
	}

}
