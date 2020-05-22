package com.learning.springboot.crudlearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.springboot.crudlearning.entity.Employee;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//No need to write anycode, or any implementation class.

}
