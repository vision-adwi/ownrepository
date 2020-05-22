package com.practice.string;

public class Palindrome {
	private static boolean isPalindrome(String word) {
		byte[] arrayBytes = word.getBytes();
		return validate(arrayBytes, 0, arrayBytes.length - 1);
	}
	
	private static boolean validate(byte[] byteArray, int head, int tail) {
		if (head >= tail)
			return true;

		if (!isAlphanumeric(byteArray[head])) {
			return validate(byteArray, head + 1, tail);
		} else if (!isAlphanumeric(byteArray[tail])) {
			return validate(byteArray, head, tail - 1);
		} else {
			if (convertLowerCase(byteArray[head]) != convertLowerCase(byteArray[tail])) {
				return false;
			}

			return validate(byteArray, head + 1, tail - 1);
		}
	}
	
	private static boolean isAlphanumeric(byte aCharacter) {
		boolean upperCase = (aCharacter >= 65 && aCharacter <= 90);
		boolean lowerCase = (aCharacter >= 97 && aCharacter <= 122);
		boolean numeric = (aCharacter >= 48 && aCharacter <= 57);
		
		return (upperCase || lowerCase || numeric);
	}
	
	private static byte convertLowerCase(byte aCharacter)  {
		boolean upperCase = (aCharacter >= 65 && aCharacter <= 90);
		if(upperCase) {
			return (byte)(aCharacter + 32);
		}
		else {
			return aCharacter;
		}
	}
	
	public static void main(String[] args) {
		String[] palindromePhrases = {"Eva, can I stab bats in a cave?", "Mr. Owl ate my metal worm", "Was it a car or a cat I saw?", 
				"A nut for a jar of tuna", "Do geese see God?", "Ma is as selfless as I am", 
				"On a clover, if alive erupts a vast pure evil, a fire volcano.", "Dammit, I'm mad!", 
				"A Toyota's a Toyota", "Go hang a salami, I'm a lasagna hog", "A Santa lived as a devil at NASA",
				"A negative scenario"};
		
		String[] palindromes = {"civic", "radar", "level", "rotor", "kayak", "reviver", "racecar", "redder", "madam", "malayalam", "refer"};
		for (String word : palindromes) {
			System.out.println(word + " is a palindrome? " + isPalindrome(word));
		}

	}

}
