package com.practice.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateCharacter {

	public static void main(String[] args) {
		//String input = "This is the test to find out if string contains any duplicates.";
		String input = "duplicates";
		System.out.println("All unique: " + allUnique(input));
		// TODO Auto-generated method stub

	}

	private static boolean allUnique(String input) {
		boolean allUniqueFlag = true;

		Set<Byte> theSet = new HashSet<>();
		for (byte character : input.getBytes()) {
			if (character != 32) { //to eliminate the white space
				allUniqueFlag = theSet.add(character);
				if (!allUniqueFlag)
					break;
			}
		}

		return allUniqueFlag;
	}
	
	private static boolean allUnique_1(String input) {
		boolean allUniqueFlag = true;

		for (byte character : input.getBytes()) {
			if (character != 32) { // to eliminate the white space
				if (input.indexOf(character) != input.lastIndexOf(character)) {
					allUniqueFlag = false;
					break;
				}
			}
		}

		return allUniqueFlag;
	}
	
	private static boolean allUnique_2(String input) {
		boolean allUniqueFlag = true;

		List<Byte> theList = new ArrayList<>();
		for (byte character : input.getBytes()) {
			if (character != 32) { // to eliminate the white space
				theList.add(character);
			}
		}
		
		Collections.sort(theList);
		for (int i = 0; i < theList.size() - 1; i++) {
			if (theList.get(i) == theList.get(i + 1)) {
				allUniqueFlag = false;
				break;
			}
		}

		return allUniqueFlag;
	}

}
