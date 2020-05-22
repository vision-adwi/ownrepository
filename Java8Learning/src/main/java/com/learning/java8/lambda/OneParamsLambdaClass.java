package com.learning.java8.lambda;

interface PrintThis {
	void print(String message);
}

public class OneParamsLambdaClass {

	public static void main(String[] s) {
		// Without lambda
		PrintThis thePrintMessage = new PrintThis() {
			public void print(String message) {
				System.out.println(message);
			}
		};
		thePrintMessage.print("One params without lambda.");

		// With lambda
		thePrintMessage = (msg) -> {
			System.out.println(msg);
		};
		thePrintMessage.print("One params with lambda.");

		// With lambda - another version
		thePrintMessage = msg -> {
			System.out.println(msg);
		};
		thePrintMessage.print("One params with lambda again.");
		
		// With lambda - simpler version
		thePrintMessage = msg -> System.out.println(msg);
		thePrintMessage.print("One params with lambda one more time.");
	}

}
