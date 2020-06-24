package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
		List<String> permuatations = new ArrayList<>();
		if(!S.isEmpty()) {
			permuatations.add(S);
			allPerm(S.getBytes(), S.length() - 1, permuatations);
		}
        
		return permuatations;
    }
	
	public void allPerm(byte[] s, int pos, List<String> permutations) {
		if(pos == -1)
			return;
		
		while(!(isUpperCase(s[pos]) || isLowerCase(s[pos]))) {
			pos--;
			if(pos < 0)
				return;
		}
		
		byte rollback = s[pos];
		if(isUpperCase(s[pos])) {
			s[pos] = (byte)(s[pos] + 32);	
		}
		else {
			s[pos] = (byte)(s[pos] - 32);
		}
		permutations.add(new String(s));
		s[pos]= rollback;
		
		allPerm(s, pos - 1, permutations);
	}
	
	private boolean isUpperCase(byte ch) {
		return ch >= 65 && ch <= 90;
	}
	
	private boolean isLowerCase(byte ch) {
		return ch >= 97 && ch <= 122;
	}

}
