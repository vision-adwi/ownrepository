package com.pattern.behavioral.strategy.concrete;

import com.pattern.behavioral.strategy.Strategy;

public class MultiplicationStrategy implements Strategy {

	@Override
	public int doOperation(int operand1, int operand2) {
		int product = operand1 * operand2;
		System.out.println("Result of multiplication(" + operand1 + " * " + operand2 + ") = " + product);
		
		return product;
	}

}
