package com.practice.string;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

public class JumbledNumerals {
	public static void main(String[] s) {
		String jumbled = "wsezvetneroo";
		// String jumbled = "threethreethreezero";
		TreeMap<Integer, Integer> numMap = new TreeMap<>();

		for (Numerals numeral : Numerals.values()) {
			if (jumbled.isEmpty()) {
				break;
			}
			while (search(jumbled, numeral.getDiff())) {
				manageCount(numMap, numeral.getDigit());
				jumbled = squeeze(jumbled, numeral.getStrValue());

			}
		}

		for (Entry<Integer, Integer> theEntry : numMap.entrySet()) {
			for (int i = 0; i < theEntry.getValue(); i++) {
				System.out.print(theEntry.getKey() + " ");
			}
		}

	}

	public static boolean search(String input, char ch) {
		return (input.indexOf(ch) != -1);
	}

	public static String squeeze(String input, String numeral) {
		byte[] inputArray = input.getBytes();
		byte[] numArray = numeral.getBytes();

		int j = 0;
		for (byte num : numArray) {
			int i = 0;
			boolean found = false;
			for (byte character : inputArray) {
				if (found || character != num) {
					inputArray[i++] = character;
				} else {
					found = true;
					j++;
				}
			}
		}

		return new String(Arrays.copyOf(inputArray, inputArray.length - j));
	}

	public static void manageCount(TreeMap<Integer, Integer> numMap, int digit) {
		Integer count = numMap.get(digit);
		if (count == null) {
			numMap.put(digit, 1);
		} else {
			numMap.put(digit, ++count);
		}
	}

	private static enum Numerals {
		ZERO(0, "zero", 'z'), 
		FOUR(4, "four", 'u'), 
		TWO(2, "two", 'w'), 
		EIGHT(8, "eight", 'g'), 
		SIX(6, "six", 'x'), 
		ONE(1, "one", 'o'), 
		THREE(3, "three", 'h'), 
		SEVEN(7, "seven", 's'), 
		FIVE(5, "five", 'v'), 
		NINE(9, "nine", 'n');

		int digit;
		String strLiteral;
		char diff;

		Numerals(int val, String str, char differentiator) {
			digit = val;
			strLiteral = str;
			diff = differentiator;
		}

		int getDigit() {
			return digit;
		}

		String getStrValue() {
			return strLiteral;
		}

		char getDiff() {
			return diff;
		}
	}
}
