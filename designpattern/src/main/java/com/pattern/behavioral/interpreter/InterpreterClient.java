package com.pattern.behavioral.interpreter;
/*
Interpreter pattern provides a way to evaluate language grammar or expression.
This pattern involves implementing an expression interface which tells to 
interpret a particular context. 

Delegation: InterpreterClient(interpret) --> Expression(interpret) --> InterpreterContext(target methods)

*/
public class InterpreterClient {
	InterpreterContext context;

	public InterpreterClient(InterpreterContext theContext) {
		context = theContext;
	}

	public String interpret(String str) {
		Expression expression = null;

		int theInput = Integer.parseInt(str.substring(0, str.indexOf(" ")));
		if (str.contains("Binary")) {
			expression = new IntToBinaryConverter(theInput);
		}
		if (str.contains("Hex")) {
			expression = new IntToHexadecimalConverter(theInput);
		}
		if (str.contains("Oct")) {
			expression = new IntToOctalConverter(theInput);
		}

		return expression.interpret(context);
	}

	public static void main(String[] args) {
		//Grammar which is going to be evaluated.
		String arg1 = "34 in Hex";

		InterpreterClient client = new InterpreterClient(
				new InterpreterContext());
		System.out.println(arg1 + " - " + client.interpret(arg1));

	}

}
