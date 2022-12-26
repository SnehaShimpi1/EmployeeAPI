package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		
		
		return employeerepository.save(employee);
	}
	
	public List<Employee> getAllEmployee(){
		
		
		return employeerepository.findAll();
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(int id) {
		
		Optional<Employee> emp=employeerepository.findById(id);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
			
		}
		else 
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public ResponseEntity<Employee> deleteEmployeeById(int id) {
	//	Employee emp=employeerepository.getById(id);
		
		Optional<Employee> emp=employeerepository.findById(id);
		                                                 	
		if(emp.isPresent()) {
			
			employeerepository.deleteById(id);
			return new ResponseEntity<Employee> (HttpStatus.OK);
			
		}
		else 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@Override
	public Employee updateEmployee(int id, Employee newemployee) {
		Employee existingEmployee=employeerepository.findById(id).get();
		 if(existingEmployee!=null) {
			 if(newemployee.getName()!=null) {
				 existingEmployee.setName(newemployee.getName());
			 }
			 if(newemployee.getAddress().getCity()!=null) {
				 existingEmployee.getAddress().setCity(newemployee.getAddress().getCity());
				 
			 }
			 employeerepository.save(existingEmployee);
		 }
		
		
		return existingEmployee;
	}
	
	
	/////2 methods are remain 1.getbyname 2.getSalaryBetween 3.usingQuery
	

	  
	  
	
	
}
