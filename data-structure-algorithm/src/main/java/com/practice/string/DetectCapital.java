package com.practice.string;

//Leetcode#520. Detect Capital

public class DetectCapital {
	public boolean detectCapitalUse_(String word) {
		if (word.length() > 1) {
			char[] words = word.toCharArray();
			if (Character.isUpperCase(words[1])) {
				if(Character.isLowerCase(words[0]))
					return false;
				
				for (int i = 2; i < words.length; i++) {
					if (Character.isLowerCase(words[i]))
						return false;
				}

			} else {
				for (int i = 2; i < words.length; i++) {
					if (Character.isUpperCase(words[i]))
						return false;
				}
			}
		}

		return true;
	}

}
