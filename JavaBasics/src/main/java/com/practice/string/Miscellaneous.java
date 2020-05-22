package com.practice.string;

import java.util.Arrays;

public class Miscellaneous {

	public static void main(String[] args) {
		String input = "This is the test to find out if string contains any duplicates.";
		//System.out.println(squeeze(input));
		System.out.println(wordCount(input));

	}

	public static String squeeze(String input) {
		byte[] byteArray = input.getBytes();

		int i = 0, j = 0;
		for (byte character : byteArray) {
			if (character != 32) {
				byteArray[i++] = character;
			} else {
				j++;
			}
		}

		return new String(Arrays.copyOf(byteArray, byteArray.length - j));
	}
	
	public static int wordCount(String input) {
		byte[] byteArray = input.getBytes();

		int count = 0;
		boolean flag = false;
		for (byte character : byteArray) {
			if (character != 32) {
				if(count == 0 || flag) {
					count++;
					flag = false;
				}
			} else {
				if(!flag) {
					flag = true;
				}
			}
		}

		return count;
	}

}
