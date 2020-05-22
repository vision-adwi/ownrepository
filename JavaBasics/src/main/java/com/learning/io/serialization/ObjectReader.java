package com.learning.io.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.learning.io.serialization.objects.Employee;
/*
ObjectInputStream throws java.io.InvalidClassException if source serialVersionUID is not matching
with local serialVersionUID.
*/
public class ObjectReader {
	public static void main(String[] args) {
		File file = new File("employee.ser");
		ObjectInputStream ois;
		Employee employee;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			employee = (Employee)ois.readObject();
			System.out.println("Persisted object is - " + employee.toString());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

}
