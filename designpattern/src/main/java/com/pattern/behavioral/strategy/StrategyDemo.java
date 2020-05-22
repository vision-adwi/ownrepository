package com.pattern.behavioral.strategy;

import com.pattern.behavioral.strategy.concrete.AdditionStrategy;
import com.pattern.behavioral.strategy.concrete.MultiplicationStrategy;

/*
Lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.
*/
public class StrategyDemo {

	public static void main(String[] args) {
		Context context = new Context(new AdditionStrategy());
		context.executeStrategy(2, 4);
		
		context.setStrategy(new MultiplicationStrategy());
		context.executeStrategy(2, 4);

	}

}
