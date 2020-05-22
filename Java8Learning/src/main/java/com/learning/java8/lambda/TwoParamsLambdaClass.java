package com.learning.java8.lambda;

interface Salary {
	int add(int base, int bonus);
}

public class TwoParamsLambdaClass {

	public static void main(String[] s) {
		// Without body and return type - only expression
		Salary theSalary = (a, b) -> (a + b);
		System.out.println("Total salay - " + theSalary.add(10000, 2000));

		// With body and return type
		theSalary = (a, b) -> {
			return a + b;
		};
		System.out.println("Total salay - " + theSalary.add(25000, 5000));

		// With body and return type - type of parameters
		theSalary = (int a, int b) -> {
			int sum = a + b;
			return sum;
		};
		System.out.println("Total salay - " + theSalary.add(5000, 1000));

	}

}

/*
 * In Java lambda expression, if there is only one statement, you may or may not use return keyword. 
 * You must use return keyword when lambda expression contains multiple statements.

*/
