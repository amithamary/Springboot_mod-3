package com.ust.emp.employeedetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.emp.employeedetails.model.Employee;
import com.ust.emp.employeedetails.services.EmployeeServices;



@RestController
@RequestMapping("/emp/details")
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	private EmployeeServices employeeservices;

	@PostMapping("/addemps")
	public Employee addEmployee(@RequestBody Employee employee)  {
		return employeeservices.createEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		return employeeservices.getEmployees();
	}

}
