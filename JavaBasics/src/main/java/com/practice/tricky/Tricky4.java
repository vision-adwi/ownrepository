package com.practice.tricky;

public class Tricky4 {

	public static void main(String[] args) {
		Integer i1 = 127;
		Integer i2 = 127;
		System.out.println("i1 == i2 -> " + (i1 == i2)); //Returns true
		
		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println("i3 == i4 -> " + (i3 == i4)); //Returns false

	}

}

//Justification - Range -128 to 127 will refer to same object as it uses IntegerCache
