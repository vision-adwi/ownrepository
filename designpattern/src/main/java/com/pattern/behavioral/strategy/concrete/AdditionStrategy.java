package com.pattern.behavioral.strategy.concrete;

import com.pattern.behavioral.strategy.Strategy;

public class AdditionStrategy implements Strategy {

	@Override
	public int doOperation(int operand1, int operand2) {
		int sum = operand1 + operand2;
		System.out.println("Result of addition(" + operand1 + " + " + operand2 + ") = " + sum);
		
		return sum;
	}

}
