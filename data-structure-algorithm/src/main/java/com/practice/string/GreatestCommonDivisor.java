package com.practice.string;
/*
Leetcode#1071. Greatest Common Divisor of Strings
For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
Return the largest string X such that X divides str1 and X divides str2.
*/
public class GreatestCommonDivisor {
	public String gcdOfStrings(String str1, String str2) {
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int minLen = c1.length < c2.length ? c1.length : c2.length;
		
		int index = 0;
		while(index < minLen && c1[index] == c2[index])
				index++;
		
		String currentDivisor = new String(c1, 0, index);
		while(currentDivisor.length() > 0) {
			if(divisible(str1, currentDivisor) && divisible(str2, currentDivisor)) {
				break;
			}
			else {
				currentDivisor = currentDivisor.substring(0, currentDivisor.length() - 1);
			}
		}
        
		return currentDivisor;
    }
	private boolean divisible(String dividend, String divisor) {
		if((dividend.length() % divisor.length()) != 0)
			return false;
		
		int start = 0; String subS;
		while(start < dividend.length()) {
			subS = dividend.substring(start, start + divisor.length());
			start = start + divisor.length();
			if(!subS.equals(divisor))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] s) {
		GreatestCommonDivisor gcd = new GreatestCommonDivisor();
		System.out.println(gcd.gcdOfStrings("LEET", "CODE"));
	}

}
