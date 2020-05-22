package com.learning.lang.reflection;

public class SubjectClass {
	String message;
	
	private SubjectClass() {
		
	}
	
	private SubjectClass(String theMessage) {
		message = theMessage;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String theMessge) {
		message = theMessge;
	}

}
