package com.learning.springboot.crudlearning.dao;

import java.util.List;

import com.learning.springboot.crudlearning.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);

}
