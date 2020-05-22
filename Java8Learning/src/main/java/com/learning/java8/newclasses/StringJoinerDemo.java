package com.learning.java8.newclasses;

import java.util.StringJoiner;

public class StringJoinerDemo {

	public static void main(String[] args) {

		StringJoiner firstList = new StringJoiner(".. ", "{", "}");
		firstList.add("Amar");
		firstList.add("Akbar");
		firstList.add("Anthony");

		System.out.println(firstList);

		StringJoiner secondList = new StringJoiner(",");
		secondList.add("John");
		secondList.add("Johny");
		secondList.add("Janardan");

		System.out.println(secondList);

		System.out.println(secondList.merge(firstList));
		//System.out.println("Length - " + secondList.merge(firstList).length());
		
		System.out.println(secondList.setEmptyValue("Empty value"));

	}

}
