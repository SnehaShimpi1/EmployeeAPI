package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee){         //or ResponseEntity<Employee>
		
		Employee emp=employeeservice.saveEmployee(employee);
		
		return emp;                                                         //or return ResponseEntity.ok().body(emp);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee(){
		
		
		
		return employeeservice.getAllEmployee();
	}
	 @GetMapping("/getById/{id}") 
	  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
	  
	  return employeeservice.getEmployeeById(id);
	  }
	  
	  @DeleteMapping("/deleteById/{id}")
	  public void deleteEmployeeById(@PathVariable("id") int id) {
		  
		employeeservice.deleteEmployeeById(id);
	  }
	  

	  
	  @PutMapping("/update/{id}")
	  public Employee updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
		  
		 
		  return employeeservice.updateEmployee(id, employee);
	  }
	
	/////2 methods are remain 1.getbyname 2.getSalaryBetween 3.usingQuery
}
