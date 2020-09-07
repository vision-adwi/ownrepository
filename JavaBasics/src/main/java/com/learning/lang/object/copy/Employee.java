package com.learning.lang.object.copy;

public class Employee extends BaseEmployee {//implements Cloneable{
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
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

} 
