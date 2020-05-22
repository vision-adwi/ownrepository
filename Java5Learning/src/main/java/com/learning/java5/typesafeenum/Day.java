package com.learning.java5.typesafeenum;

public enum Day {
	SUNDAY("Ravi-vaar"), MONDAY("Som-vaar"), TUESDAY("Mangal-vaar"), WEDNESDAY("Budh-vaar"),
	THURSDAY("Guru-vaar"), FRIDAY("Shukra-vaar"), SATURDAY("Shani-vaar");
	
	//Variable can be added
	String theHindiName;
	
	//Constructor can be added
	Day(String hindiName) {
		theHindiName = hindiName;
	}
	
	//Methods can be added
	public String getHindiName() {
		return theHindiName;
	}

}
