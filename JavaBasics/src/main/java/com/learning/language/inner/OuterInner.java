package com.learning.language.inner;

public class OuterInner {
	private static int static_var;
	private int x;
	
	class Inner {
		//Variable name can be shared by outer and inner classes.
		private int x;
		//static String NO_MSG = "This can not be declared inside a non-static inner class";
		static final String MSG = "Only a final static can be declared inside a non-static "
				+ "inner class";
		
		public void setOuterMember(int value) {
			static_var = value;
		}
		public void setInnerMember(int value) {
			OuterInner.this.x = value;
			x = value;
			
		}
		public int getOuterMember() {
			return OuterInner.this.x;
		}
		public int getInnerMember() {
			return this.x;
		}
		//Static methods can only be declared in a static or top level class
		/*
		public static void display() {
			
		}
		*/
	}
	
	public int getValue() {
		return static_var;
	}

}
