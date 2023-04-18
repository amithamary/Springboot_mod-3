package com.ust.emp.employeedetails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.emp.employeedetails.model.Employee;
import com.ust.emp.employeedetails.repository.EmployeeRepo;

@Service
public class EmployeeServices {
	@Autowired
	private EmployeeRepo repo;

	public Employee createEmployee(Employee employee) 
	{
		
		return repo.save(employee);
	}
	public List<Employee> getEmployees()
	{
		return repo.findAll();
	}

	

}
