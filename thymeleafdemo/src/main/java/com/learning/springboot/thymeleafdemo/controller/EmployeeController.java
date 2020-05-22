package com.learning.springboot.thymeleafdemo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.springboot.thymeleafdemo.entity.Employee;
import com.learning.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/date")
	public String sayHello(Model theModel) {
		theModel.addAttribute("theDate", new Date());
		
		return "helloworld";
		
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployee = employeeService.findAll();
		
		theModel.addAttribute("employees", theEmployee);
		
		return "employees/list-employees";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";

	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		Employee theEmployee = employeeService.findById(theId);
		
		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int theId, Model theModel) {
		employeeService.deleteById(theId);

		return "redirect:/employees/list";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);

		return "redirect:/employees/list";
		
	}


}
