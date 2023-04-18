package com.ust.emp.employeedetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.emp.employeedetails.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String>{

}
