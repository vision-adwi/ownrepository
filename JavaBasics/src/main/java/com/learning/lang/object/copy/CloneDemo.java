package com.learning.lang.object.copy;

public class CloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Address address = new Address("B2-404", "Poetree", "12th Cross", "Bangalore", 560035);
		Employee employee = new Employee("K9998", 155000, address);
		employee.setLocation("Cracko");
		System.out.println(employee);
		
		Employee employeeCopy = (Employee)employee.clone();
		System.out.println(employeeCopy);

	}

}
