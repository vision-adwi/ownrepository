package com.practice.string;

public class AllPermutations {

	public static void main(String[] args) {
		String str = "FISH";
		int count = 0;
		count = permutations("", str.toCharArray(), count);
		System.out.println("Total Number of permutations - " + count);

	}
	
	private static int permutations(String resultant, char[] remaining, int count) {
		if (remaining.length <= 0) {
			System.out.println(resultant);
			return ++count;
		}
		for (char aChar : remaining) {
			count = permutations(resultant + aChar, remove(remaining, aChar), count);
		}
		
		return count;
	}
	
	private static char[] remove(char[] charArray, char aValue) {
		int i = 0;
		char[] newData = new char[charArray.length - 1];
		for (char aChar : charArray) {
			if (aValue != aChar) {
				newData[i++] = aChar;
			}
		}

		return newData;
	}

}
