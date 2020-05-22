package com.learning.io.externalization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.learning.io.externalization.objects.Employee;
/*
There must be a default constructor for class which implements the Externalizable interface otherwise
deserialization will fail.
Data should be read in the same order it was written.
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
