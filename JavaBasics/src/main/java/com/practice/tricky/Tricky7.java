package com.practice.tricky;

public class Tricky7 {
	
	public static void print() {
		System.out.println("Static method");
	}

	public static void main(String[] args) {
		Tricky7 tricky = null;
		tricky.print();

	}

}

//Justification - A call to static method is resolved to a class but not the object reference.
