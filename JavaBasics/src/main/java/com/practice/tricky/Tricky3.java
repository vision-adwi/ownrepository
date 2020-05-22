package com.practice.tricky;

public class Tricky3 {
	private static void overloaded(Object obj) {
		System.out.println("This is the method with Object parameter");
	}
	
	private static void overloaded(String obj) {
		System.out.println("This is the method with String parameter");
	}
	
	private static void overloaded(StringBuilder obj) {
		System.out.println("This is the method with StringBuilder parameter");
	}

	public static void main(String[] args) {
		//Below call is ambiguous
		//overloaded(null);
		
		

		//Below call is similar to above and that ambiguous too
		//System.out.println(null);
	}

}

//Justification - There is ambiguity in caller as String and StringBuilder are not in hierarchy and either of them
//are qualified for the literal 'null'

