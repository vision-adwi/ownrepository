package com.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursionDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = mainMenu(scanner);
		
		System.out.println("Choice entered: " + choice);
		doOperation(choice);
		
		List<Integer> numbers;
		int input = 0;
		if(choice==3) {
			numbers = new ArrayList<>();
		}
		else {
			input = scanner.nextInt();
		}
		
		switch(choice) {
		case 1:
			int f = factorial(input);
			System.out.println("Factorial of " + input + " is " + f);
			break;
		case 2: 
			int fi = fibonacci(input);
			System.out.println("Fibonacci of " + input + " is " + fi);
			break;
		case 3:
			break;
		}
		
		
		

		scanner.close();
	}
	
	static int factorial(int n) {
		if (n < 1) {
			return 1;

		} else {
			return n * factorial(n - 1);
		}
	}
	
	static int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return n-1;
		} 
		else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	
	private static int mainMenu(Scanner scanner) {
		System.out.println("Choice of functions....");
		System.out.println("1. Factorial");
		System.out.println("2. Fibonacci");
		System.out.println("3. Search largest number");
		
		int input = scanner.nextInt();
		
		return input;
	}
	
	private static void doOperation(int choice) {
		switch(choice) {
		case 1: 
			System.out.println("Enter the number for which fibonacci value is required - ");
			break;
		case 2:
			System.out.println("Enter the number for which factorial value is required - ");
			break;
		case 3:
			System.out.println("Enter the numbers of the list: ");
			break;
		default:
			break;
		}
	}

}
