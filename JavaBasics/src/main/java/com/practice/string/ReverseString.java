package com.practice.string;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ReverseString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		do {
			System.out.print("Original: ");
			input = scanner.nextLine();
			System.out.println("Reverse: " + reverse(input));

		} while (!input.equals("done"));
		
		scanner.close();
	}

	private static String reverse(String original) {
		//Method-1
		long start = System.nanoTime();
		byte[] byteArray = original.getBytes();
		reverseSwap(byteArray, 0, byteArray.length - 1);
		new String(byteArray);
		long end = System.nanoTime();
		System.out.println("Time taken(method-1) : " + (end - start));
		
		//Method-2
		start = System.nanoTime();
		reverseConcat(original);
		end = System.nanoTime();
		System.out.println("Time taken(method-2) : " + (end - start));
		
		//Method-3
		start = System.nanoTime();
		String reversed = reverseRaw(original);
		end = System.nanoTime();
		System.out.println("Time taken(method-3) : " + (end - start));
		return reversed;
	}

	private static void reverseSwap(byte[] bytes, int start, int end) {
		if (start < end) {
			byte tmp = bytes[start];
			bytes[start] = bytes[end];
			bytes[end] = tmp;

			reverseSwap(bytes, start + 1, end - 1);
		}

	}
	
	//String creation for each substring and concatenation
	//Time complexity - O(n)
	private static String reverseConcat(String input) {
		if (input.isEmpty()) {
			return input;
		}
		return reverseConcat(input.substring(1)) + input.charAt(0);
	}
	
	//Addition space of O(n)
	//Time complexity O(n) - double than any better solution
	private static String reverseRaw(String original) {
		int strLength = original.length();
		byte[] sourceArray = original.getBytes();
		byte[] targetArray = new byte[strLength];

		for (int i = 0; i < strLength; i++) {
			targetArray[i] = sourceArray[(strLength - 1) - i];
		}
		
		return new String(targetArray);
	}
	
	/*private static void reverseStream(String original) {
		return IntStream.range(0, original.length())
				.map(i -> original.charAt(original.length() - i - 1))
				.collect(StringBuilder::new, (s, c) -> s.append((char) c), String(s));
		
	}*/

}
