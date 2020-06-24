package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CaseConversion {
	public void conversion(String s) {
		convert(s.getBytes(), new ArrayList<>(), 0);
	}
	
	private void convert(byte[] str, List<Byte> curr, int index) {
		if(index == str.length) {
			StringBuilder builder = new StringBuilder("");
			for(byte by: curr)
				builder.append((char)by);
			
			System.out.println("Result: " + builder);
			
			return;
		}
		
		while(!((str[index] >= 65 && str[index] <= 90) || (str[index] >= 97 && str[index] <= 122))) {
			curr.add(str[index++]);
		}
		
		byte newChar = toLowerCase(str[index]);
		curr.add(newChar);
		convert(str, curr, index + 1);
		curr.remove(curr.size() - 1);
		
		newChar = toUpperCase(str[index]);
		curr.add(newChar);
		convert(str, curr, index + 1);
		curr.remove(curr.size() - 1);
	}

	private byte toLowerCase(byte ch) {
		if(ch >= 65 && ch <= 90)
			return (byte)(ch + 32);
		else
			return ch;
	}
	
	private byte toUpperCase(byte ch) {
		if(ch >= 97 && ch <= 122)
			return (byte)(ch - 32);
		else
			return ch;
	}
	
	public static void main(String[] s) {
		CaseConversion conv = new CaseConversion();
		conv.conversion("abc");
	}

}
