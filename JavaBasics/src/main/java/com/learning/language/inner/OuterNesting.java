package com.learning.language.inner;

public class OuterNesting {
	static String STATIC_MEMBER = "Static Member"; 
	private int non_static = 10;
	
	static class Nested {
		int i = 5;
		public void display() {
			System.out.println("Can not refer non_static members of outer class.");
			System.out.println("Can access static members of outer class:" + STATIC_MEMBER);
			System.out.println("Can access non-static members of it's own class:" + i);
		}
		
		public static String getStaticMemberOfOuterClass() {
			return STATIC_MEMBER;
		}
		
		public int getNonStaticMemberOfOuterClass() {
			return i;
		}
	}
	
	public static String getStaticMember() {
		return STATIC_MEMBER;
	}
	
	public int getValue() {
		return non_static;
	}

}
