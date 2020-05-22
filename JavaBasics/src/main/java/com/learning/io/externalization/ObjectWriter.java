package com.learning.io.externalization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.learning.io.externalization.objects.Address;
import com.learning.io.externalization.objects.Employee;

public class ObjectWriter {

	public static void main(String[] args) {
		Address address = new Address("B2-404", "Poetree", "12th Cross", "Bangalore", 560035);
		Employee employee = new Employee("K9998", 155000, address);
		employee.setLocation("Cracko");
		File file = new File("employee.ser");
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			System.out.println("Object being persisted is - " + employee.toString());
			oos.writeObject(employee);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
