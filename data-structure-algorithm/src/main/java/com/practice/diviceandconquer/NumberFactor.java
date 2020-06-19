package com.practice.diviceandconquer;
/*
Problem statement
Given N, count the number of ways to express N as the sum of 1, 3 and 5.
*/
public class NumberFactor {

	public static void main(String[] args) {
		NumberFactor fact = new NumberFactor();
		System.out.println(fact.solve(7));


	}
	
	public long waysToGet(int n) {
		if((n == 0) || (n == 1) || (n == 2)) { //[{}], [{1}], [{1,1}]
			return 1L;
		}
		if(n == 3) { //[{1,1,1}, {3}]
			return 2L;
		}
		if(n == 4) { //[{1,1,1,1}, {1,3}, {3,1}]
			return 3L;
		}

		long subtract1 = waysToGet(n - 5);
		long subtract2 = waysToGet(n - 3);
		long subtract3 = waysToGet(n - 1);
		
		long sum = subtract1 + subtract2 + subtract3;
		return sum;
	}

	public long solve(int n) {
		return waysToGet(n);
	}

}
