package com.learning.libraries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExercise {
	public static void main(String[] args) {
		//Way - 1
		Pattern pattern = Pattern.compile("[ab]+");
		Matcher match = pattern.matcher("baba");
		
		System.out.print("\n[ab]+    " );
		System.out.print(" : baba - " + match.matches());
		System.out.print(" : cab - " + pattern.matcher("cab").matches());
		System.out.print(" : {} - " + pattern.matcher("").matches());
		
		Pattern pattern1 = Pattern.compile("[ab]*");
		System.out.print("\n[ab]*    " );
		System.out.print(" : baba - " + pattern1.matcher("baba").matches());
		System.out.print(" : cab - " + pattern1.matcher("cab").matches());
		System.out.print(" : {} - " + pattern1.matcher("").matches());
		
		Pattern pattern2 = Pattern.compile("[a-zA-Z]");
		System.out.print("\n[a-zA-Z] " );
		System.out.print(" : A    - " + pattern2.matcher("A").matches());
		System.out.print(" : cab - " + pattern2.matcher("cab").matches());
		System.out.print(" : {} - " + pattern2.matcher("").matches());

		System.out.print("\n[a-zA-Z]+" );
		System.out.print(" : A    - " + Pattern.matches("[a-zA-Z]+", "A"));
		System.out.print(" : cab - " + Pattern.matches("[a-zA-Z]+", "cab"));
		System.out.print(" : {} - " + Pattern.matches("[a-zA-Z]+", ""));
	}
	
	/*
	 * [abc]		- a, b or c [Simple class]
	 * [^abc]		- Any character except a, b or c[negation]
	 * [a-zA-Z]		- a through z or A through Z, inclusive (range)
	 * [a-d[m-p]]	- 
	 * 
	 */
}
