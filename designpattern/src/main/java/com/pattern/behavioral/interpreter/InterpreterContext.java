package com.pattern.behavioral.interpreter;

public class InterpreterContext {
	public String getHexadecimalFormat(int input) {
		return Integer.toHexString(input);
	}
	
	public String getBinaryFormat(int input) {
		return Integer.toBinaryString(input);
	}
	
	public String getOctalFormat(int input) {
		return Integer.toOctalString(input);
	}

}
