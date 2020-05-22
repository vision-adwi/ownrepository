package com.pattern.creational.prototype;

//Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.
public class PrototypeDemo {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setId(341);
		employee.setName("Harry");
		employee.setDesignation("Chief Manager");
		employee.setSalary(24500);
		
		System.out.println(employee);
		
		Employee clonedEmployee = (Employee)employee.getPrototype();
		System.out.println(clonedEmployee);

	}

}
