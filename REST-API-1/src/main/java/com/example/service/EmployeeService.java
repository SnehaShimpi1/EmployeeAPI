package com.example.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Employee;


public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	
	public ResponseEntity<Employee> getEmployeeById(int id);
	
	public ResponseEntity<Employee> deleteEmployeeById(int id);
	
	 public Employee updateEmployee(int id,Employee employee);
		  
	
}
