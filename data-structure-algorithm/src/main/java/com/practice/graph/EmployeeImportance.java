package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* Leetcode #690. Employee Importance
You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.
For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. 
Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is
also a subordinate of employee 1, the relationship is not direct.
Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his 
subordinates.
*/
public class EmployeeImportance {
	public static void main(String[] s) {
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee(1, 5, new ArrayList<>());
		Employee e2 = new Employee(2, 15, new ArrayList<>());
		Employee e3 = new Employee(3, 25, Arrays.asList(2, 5));
		Employee e5 = new Employee(5, 10, Arrays.asList(1));
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e5);
		
		EmployeeImportance imp = new EmployeeImportance();
		System.out.println(imp.getImportance(employees, 5));
	}
	
	
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> employeeMap = new HashMap<>();
		for(Employee emp:employees) {
			employeeMap.put(emp.id, emp);
		}
		
		Employee theEmp = employeeMap.get(id);
		return importance(employeeMap, theEmp, 0);
	}
	
	private int importance(Map<Integer, Employee> employeeMap, Employee theEmployee, int count) {
		for (Integer subordinate : theEmployee.subordinates) {
			Employee theEmp = employeeMap.get(subordinate);
			count = importance(employeeMap, theEmp, count);
		}

		return count + theEmployee.importance;
	}

}

//Definition for Employee.
class Employee {
	public Employee(int id, int importance, List<Integer> subordinates) {
		this.id = id;
		this.importance = importance;
		this.subordinates = subordinates;
	}

	public int id;
	public int importance;
	public List<Integer> subordinates;
}
