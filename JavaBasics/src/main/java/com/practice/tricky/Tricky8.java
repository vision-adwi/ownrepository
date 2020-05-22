package com.practice.tricky;

public class Tricky8 {
	private static int resolve(int threshold) {
		return (threshold > 50) ? null : threshold;
	}

	public static void main(String[] args) {
		//Below line will throw NullPointerException
		//System.out.println(resolve(51));
		
		System.out.println(resolve(49));

	}

}
//Justification - This is valid at compile time but whenever null is mapped to int, this will throw 
//NullPointerException
