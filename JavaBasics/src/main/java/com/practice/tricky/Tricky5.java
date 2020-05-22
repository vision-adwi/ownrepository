package com.practice.tricky;

public class Tricky5 {

	public static void main(String[] args) {
		//Below statement will cause runtime exception(NumberFormatException)
		Integer i1 = new Integer(null);
		
		//In the below statement, there is ambiguity in constructor overloading - Compile time error
		//String s1 = new String(null);

	}

}
