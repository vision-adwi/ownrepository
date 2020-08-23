package com.practice.string;
/*
Leetcode#38. Count and Say
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
*/
public class CountAndSay {	
    public String countAndSay(int n) {  	
    	return countNum(n - 1, "1");       
    }
    
	private String countNum(int remaining, String s) {
		if (remaining == 0)
			return s;

		StringBuilder builder = new StringBuilder();
		int i = 0;
		while (i < s.length()) {
			int count = 1;
			char number = s.charAt(i++);
			while (i < s.length() && s.charAt(i) == number) {
				count++;
				i++;
			}

			builder.append(Character.forDigit(count, 10)).append(number);
		}

		return countNum(remaining - 1, builder.toString());
	}
	
	public static void main(String[] s) {
		CountAndSay say = new CountAndSay();
		
		System.out.println(say.countAndSay(5));
	}

}
