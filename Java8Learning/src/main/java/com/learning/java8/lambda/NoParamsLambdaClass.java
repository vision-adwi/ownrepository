package com.learning.java8.lambda;

interface PrintMessage {
	void print();
}

public class NoParamsLambdaClass {

	public static void main(String[] s) {
		// Without lambda
		PrintMessage thePrintMessage = new PrintMessage() {
			public void print() {
				System.out.println("Print Now...");
			}
		};
		thePrintMessage.print();

		// With lambda
		thePrintMessage = () -> {
			System.out.println("Print Now...");
		};
		thePrintMessage.print();

		// With lambda-One more way
		thePrintMessage = () -> System.out.println("Print Now...");

		thePrintMessage.print();
	}

}

/*
 * Java lambda expression is treated as a function, so compiler does not create .class file.
 * Lambda expression provides implementation of functional interface. An interface which has only one abstract method is called functional interface.
 * Java provides an anotation @FunctionalInterface, which is used to declare an interface as functional interface.(Optional)
 * 
 * Java lambda expression is consisted of three components.
 * 1) Argument-list: It can be empty or non-empty as well.
 * 2) Arrow-token: It is used to link arguments-list and body of expression.
 * 3) Body: It contains expressions and statements for lambda expression.
 * */
