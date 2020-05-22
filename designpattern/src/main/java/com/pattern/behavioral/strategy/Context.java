package com.pattern.behavioral.strategy;

public class Context {
	private Strategy strategy;
	
	public Context(Strategy theStrategy) {
		this.strategy = theStrategy;
	}
	
	public void setStrategy(Strategy theStrategy) {
		this.strategy = theStrategy;
	}
	
	public int executeStrategy(int operand1, int operand2) {
		return this.strategy.doOperation(operand1, operand2);
	}

}
