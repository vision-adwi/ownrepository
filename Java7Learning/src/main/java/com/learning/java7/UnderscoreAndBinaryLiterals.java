package com.learning.java7;

public class UnderscoreAndBinaryLiterals {

	public static void main(String[] args) {
		int thousandSeparator = 10_000; // Underscore in integral literal 
		float floatSeparator = 5.000_1f; // Underscore in floating literal
		int binaryLiteral = 0B1111_1010_1111; // Underscore in binary literal 
		int hexaDecLiteral = 0xEA_BC; //// Underscore in hexadecimal literal
		int octalLiteral = 0777_7; // Underscore in octal literal  
		
		System.out.println(thousandSeparator);
		System.out.println(floatSeparator);
		System.out.println(binaryLiteral);
		System.out.println(hexaDecLiteral);
		System.out.println(octalLiteral);
	}

}

/*
-Improves readability.
Compilation Errors
int a = _10; // Error, this is an identifier, not a numeric literal
int a = 10_; // Error, cannot put underscores at the end of a number
float a = 10._0; // Error, cannot put underscores adjacent to a decimal point  
float a = 10_.0; // Error, cannot put underscores adjacent to a decimal point 
long a = 10_100_00_L; // Error, cannot put underscores prior to an L suffix  
*/
