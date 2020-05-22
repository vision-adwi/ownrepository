package com.learning.java5.typesafeenum;

public enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE;
	
	double eval(double x, double y) {
		switch (this) {
		case ADD:
			return (x + y);
		case SUBTRACT:
			return (x - y);
		case MULTIPLY:
			return (x * y);
		case DIVIDE:
			return (x / y);
		}
		throw new AssertionError();
	}

}
