package com.learning.java8.abstractandinterface;

//Interface can not have constructor
interface CalculationInterface {

	//Implementation method should be tagged with default keyword
	default void arithmetic(int operand1, int operand2, Calculations operation) {
		int result;
		switch (operation) {
		case ADD:
			result = add(operand1, operand2);
			break;
		case SUBTRACT:
			result = subtract(operand1, operand2);
			break;
		case MULTIPLY:
			result = multiply(operand1, operand2);
			break;
		case DIVIDE:
			result = divide(operand1, operand2);
			break;
		default:
			result = 0;
		}

		System.out.println("Operation - " + operation.name() + " Operands - "
				+ operand1 + ", " + operand2 + " Result - " + result);
	}

	default int add(int operand1, int operand2) {
		return operand1 + operand2;
	}

	int subtract(int operand1, int operand2);

	int multiply(int operand1, int operand2);

	int divide(int operand1, int operand2);

	//Interface can have static methods
	static void message() {
		System.out.println("It takes 2 arguments and an operand to calculate.");
	}
}

public class InterfaceDemo implements CalculationInterface {
	public static void main(String[] s) {
		CalculationInterface.message();

		CalculationInterface calculation = new InterfaceDemo();
		calculation.arithmetic(5, 2, Calculations.ADD);

	}

	@Override
	public int subtract(int operand1, int operand2) {
		return operand1 - operand2;
	}

	@Override
	public int multiply(int operand1, int operand2) {
		return operand1 * operand2;
	}

	@Override
	public int divide(int operand1, int operand2) {
		return operand1 / operand2;
	}
}

enum Calculations {
	ADD, SUBTRACT, MULTIPLY, DIVIDE;
}
