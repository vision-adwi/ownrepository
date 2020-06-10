package com.practice.bitwise;

public class NumberTests {

	public static void main(String[] args) {
		System.out.println("17 is even - " + isEven(17));

	}
	
	private static boolean isEven(int num) {
		if((num & 1) == 0)
			return true;
		else
			return false;
	}

}
