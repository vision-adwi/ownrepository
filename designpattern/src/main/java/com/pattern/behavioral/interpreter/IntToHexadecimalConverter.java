package com.pattern.behavioral.interpreter;

public class IntToHexadecimalConverter implements Expression {

	int input;
	
	public IntToHexadecimalConverter(int theInput) {
		input = theInput;
	}
	@Override
	public String interpret(InterpreterContext context) {
		return context.getHexadecimalFormat(input);
	}

}
