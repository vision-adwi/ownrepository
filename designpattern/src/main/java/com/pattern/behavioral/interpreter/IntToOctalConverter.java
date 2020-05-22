package com.pattern.behavioral.interpreter;

public class IntToOctalConverter implements Expression {
	int input;
	
	public IntToOctalConverter(int theInput) {
		input = theInput;
	}
	@Override
	public String interpret(InterpreterContext context) {
		return context.getOctalFormat(input);
	}

}
