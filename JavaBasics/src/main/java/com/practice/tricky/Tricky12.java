package com.practice.tricky;

public class Tricky12 {

	public static void main(String[] args) {
		charAddition();
		
		//Common mistake with StringBuffer - Below statement will not instantiate StringBuffer
		//with character c, but it will initialize with capacity 99(ascii value of c)
		StringBuffer sb = new StringBuffer('c');
	}
	
	private static void charAddition() {
		System.out.println('h' + 'i');
		System.out.println(3 + 'i');
		System.out.println('h' + "i");
		System.out.println((char)104 + "i");
		System.out.println(104 + "i");
	}

}
