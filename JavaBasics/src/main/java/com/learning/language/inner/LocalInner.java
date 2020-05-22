package com.learning.language.inner;

public class LocalInner {
	private String val = "Outer";
	
	public String getData() {
		class Local {
			int class_local = 9;
			static final String MSG = "This is feasible";
			//static String NO_MSG = "This is not feasible";
			private String getOuter() {
				return val;
			}
			private int getLocalVar() {
				return class_local;
			}
		}
		
		return new Local().getOuter();
	}

}
