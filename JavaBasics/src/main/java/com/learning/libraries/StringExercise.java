package com.learning.libraries;

public class StringExercise {

	public static void main(String[] args) {
		String myJob = new String("Specialist");
		//stringMethods(myJob);
		
		StringBuffer buffer = new StringBuffer();
		
	
		
		StringBuilder builder = new StringBuilder();
		stringBuilderMethod(builder);

	}
	
	private static void stringMethods(String str) {
		System.out.println(str.concat(" Engineer"));
		System.out.print("Contains (Z): " + str.contains("Z"));
		System.out.println(", Contains (p): " + str.contains("p"));
		System.out.println("Position (i): " + str.indexOf('i'));
		System.out.println("Position (list): " + str.indexOf("list"));
	}
	
	private static void stringBuilderMethod(StringBuilder builder) {
		System.out.println(builder.append("Twinkle"));
		//builder.
	}

}
