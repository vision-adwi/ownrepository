package com.learning.util.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExercise {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("Ram", "Prasad", "Bismil"),
				new Employee("Ashok", "Kumar", "Tripathi"),
				new Employee("Rajesh", "Ranjan", "Pandey"),
				new Employee("Rajesh", "Ranjan", "Kaushik"),
				new Employee("Ashok", "Lal", "Singh"));
		
		employees.forEach(System.out::println);
		System.out.println("\nAfter Sorting...");
		employees.sort(new EmpComparator1());
		employees.forEach(System.out::println);
	}

}

class EmpComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.firstName.compareTo(o2.firstName);
	}
	
}

class EmpComparator1 implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		int firstNameCompare = o1.firstName.compareTo(o2.firstName);
		if(firstNameCompare == 0) {
			int middleNameCompare = o1.middleName.compareTo(o2.middleName);
			if(middleNameCompare == 0) {
				return o1.lastName.compareTo(o2.lastName);
			}
			else {
				return middleNameCompare;
			}
		}
		else {
			return firstNameCompare;
		}
	}
	
}

class Employee {
	String firstName;
	String middleName;
	String lastName;
	
	public Employee(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " +  middleName + " " + lastName;
	}
}
