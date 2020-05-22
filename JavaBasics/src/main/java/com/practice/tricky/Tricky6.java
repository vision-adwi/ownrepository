package com.practice.tricky;

public class Tricky6 {
	public static void main(String... s) {
		System.out.println(StaticConstant.x);
	}

}

class StaticConstant {
	public final static int x = 100;
	static {
		System.out.println("Class \'StaticConstant\' is loading...");
	}
}

//Justification - static final variables are resolved at compile time, so there is no
//run time loading of the class