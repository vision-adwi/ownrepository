package com.pattern.behavioral.interpreter;

public class IntToBinaryConverter implements Expression{
	int input;
	
	public IntToBinaryConverter(int theInput) {
		input = theInput;
	}
	@Override
	public String interpret(InterpreterContext context) {
		return context.getBinaryFormat(input);
	}

}
