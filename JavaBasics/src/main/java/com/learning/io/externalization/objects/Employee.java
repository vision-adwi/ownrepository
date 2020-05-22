package com.learning.io.externalization.objects;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
/*
If class is not implementing Serializable interface then it will throw java.io.NotSerializableException
if attempted to be serialized.
*/
public class Employee implements Externalizable{
	private String id;
	private int salary;
	private Address address;
	private String location = "Bangalore";
	public Employee() {
	}
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
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(address);
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		address = (Address)in.readObject();
		id = (String)in.readObject();
		
		
	}

}
