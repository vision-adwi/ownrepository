package com.learning.io.serialization.objects;

import java.io.Serializable;
/*
All classes of object graph must implement serializable
*/
public class Address implements Serializable{
	private long zip;
	private String doorNo;
	private String street;
	private String city;
	private String building;
	
	public Address(String doorNo, String building, String street, String city,
			int zip) {
		super();
		this.doorNo = doorNo;
		this.building = building;
		this.street = street;
		this.city = city;
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [Door No. - " + doorNo + "," + building
				+ "\n" + street + "\nCity - " + city + " Zip - " + zip
				+ "]";
	}
	

}
