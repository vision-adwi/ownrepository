package com.practice.bitwise;

public class Swap {

	public static void main(String[] args) {
		int a = 568;
		int b = 721908;
		
		System.out.println("Before swap - a = " + a + " b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.println("After swap  - a = " + a + " b = " + b);

	}

}
