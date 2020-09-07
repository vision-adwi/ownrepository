package com.learning.language.inner;

public class LocalInner {
	private String val = "Outer";
	private static String str = "StaticStr";
	
	public String getData() {
		class Local {
			int class_local = 9;
			static final String MSG = "This is feasible";
			//static String NO_MSG = "This is not feasible";
			private String getOuter() {
				return val;
			}
			private String getStaticOuter() {
				return str;
			}
			private int getLocalVar() {
				return class_local;
			}
			/*
			private static int stMethod() {
				return 0;
			}*/
		}
		
		return new Local().getOuter();
	}

}
