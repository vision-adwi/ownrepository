package com.learning.java8.abstractandinterface;

abstract class AbstractCalculation {
	
	//Abstract class has constructor but interface doesn't.
	public AbstractCalculation() {
	}
	
	public void arithmetic(int operand1, int operand2, Operation operation) {
		int result;
		switch (operation) {
		case ADD: 
			result = add(operand1, operand2 );
			break;
		case SUBTRACT:
			result = subtract(operand1, operand2 );
			break;
		case MULTIPLY:
			result = multiply(operand1, operand2 );
			break;
		case DIVIDE:
			result = divide(operand1, operand2 );
			break;
		default: 
			result = 0;
		}
		
		System.out.println("Operation - " + operation.name() + " Operands - " + operand1 + ", " + operand2 + " Result - " + result);
	}
	
	int add(int operand1, int operand2 ) {
		return operand1 + operand2;
	}
	
	abstract int subtract(int operand1, int operand2 );
	abstract int multiply(int operand1, int operand2 );
	abstract int divide(int operand1, int operand2 );
	
	static void message() {
		System.out.println("It takes 2 arguments and an operand to calculate.");
	}
}

public class CalculationDemo extends AbstractCalculation{
	public static void main(String[] s) {
		AbstractCalculation.message();
		
		AbstractCalculation calculation = new CalculationDemo();
		calculation.arithmetic(5, 2, Operation.ADD);
		
	}

	@Override
	int subtract(int operand1, int operand2) {
		return operand1 - operand2;
	}

	@Override
	int multiply(int operand1, int operand2) {
		return operand1 * operand2;
	}

	@Override
	int divide(int operand1, int operand2) {
		return operand1 / operand2;
	}
}

enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE;
}
