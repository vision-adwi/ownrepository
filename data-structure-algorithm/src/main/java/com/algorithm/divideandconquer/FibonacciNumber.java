package com.algorithm.divideandconquer;

import com.algorithm.IFibonacciNumber;

public class FibonacciNumber implements IFibonacciNumber{
	@Override
	public int calculate(int n) {
		if(n <= 2)
			return n - 1;
		
		int n1 = calculate(n - 1);
		int n2 = calculate(n - 2);
		
		return n1 + n2;
	}

}
