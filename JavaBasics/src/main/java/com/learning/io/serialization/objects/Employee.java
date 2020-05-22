package com.learning.io.serialization.objects;

import java.io.Serializable;

/*
If class is not implementing Serializable interface then it will throw java.io.NotSerializableException
if attempted to be serialized.
*/
public class Employee implements Serializable{
	private String id;
	private transient int salary;
	private Address address;
	private static String location = "Bangalore";
	public Employee(String id, int salary, Address address) {
		super();
		this.id = id;
		this.salary = salary;
		this.address = address;
	}
	public void setLocation(String theLocation) {
		location = theLocation;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", loaction=" + location + "\n" + address + "]";
	}

}
