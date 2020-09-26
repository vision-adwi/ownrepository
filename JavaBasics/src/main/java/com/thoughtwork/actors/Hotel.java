package com.thoughtwork.actors;

public enum Hotel {
	SILVER(200, 50), GOLD(300, 150), PLATINUM(500, 300);

	Integer rent;
	Integer value;
	Hotel(int theValue, int theRent) {
		value = theValue;
		rent = theRent;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getRent() {
		return rent;
	}
}
