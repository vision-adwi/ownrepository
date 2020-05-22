package com.learning.java5.generics.custom;

public class Child extends Parent{

	int theA;
	int theB;

	public Child(int a, int b) {
		theA = a;
		theB = b;
	}

	@Override
	public String toString() {
		return super.toString() + (theA + theB);
	}
}
