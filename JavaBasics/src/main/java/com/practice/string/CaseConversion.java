package com.practice.string;

public class CaseConversion {

	public static void main(String[] args) {
		String input = "Radhe Shyam";
		System.out.println("Original              : " + input);
		System.out.println("Converted(toLowerCase): " + toLowerCase(input));
		System.out.println("Converted(toUpperCase): " + toUpperCase(input));
		System.out.println("Converted(reverseCase): " + reverseCase(input));
	}

	private static String toLowerCase(String input) {
		byte[] characters = input.getBytes();
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] >= 65 && characters[i] <= 90) {
				characters[i] = (byte) (characters[i] + 32);
			}
		}
		return new String(characters);
	}
	
	private static String toUpperCase(String input) {
		byte[] characters = input.getBytes();
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] >= 97 && characters[i] <= 122) {
				characters[i] = (byte) (characters[i] - 32);
			}
		}
		return new String(characters);
	}
	
	private static String reverseCase(String input) {
		byte[] characters = input.getBytes();
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] >= 65 && characters[i] <= 90) {
				characters[i] = (byte) (characters[i] + 32);
			}
			else if (characters[i] >= 97 && characters[i] <= 122) {
				characters[i] = (byte) (characters[i] - 32);
			}
		}
		return new String(characters);
	}

}
