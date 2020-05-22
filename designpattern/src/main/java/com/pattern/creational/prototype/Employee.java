package com.pattern.creational.prototype;

public class Employee implements Prototype {
	private int id;
	private String name;
	private String designation;
	private float salary;
	
	public Employee() {
		
	}

	public Employee(int id, String name, String designation, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation="
				+ designation + ", salary=" + salary + "]";
	}

	@Override
	public Prototype getPrototype() {
		return new Employee(this.id, this.name, this.designation, this.salary);
	}

}
