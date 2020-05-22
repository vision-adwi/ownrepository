package com.practice.tricky;

public class Tricky2 {
	private static void overloaded(Object obj) {
		System.out.println("This is the method with Object parameter");
	}
	
	private static void overloaded(String obj) {
		System.out.println("This is the method with String parameter");
	}

	public static void main(String[] args) {
		overloaded(null);

	}

}

//Justification - An overloaded method with more specific parameter is called

