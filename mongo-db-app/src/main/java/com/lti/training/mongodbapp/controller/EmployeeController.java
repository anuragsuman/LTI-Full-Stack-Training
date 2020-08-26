package com.lti.training.mongodbapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.mongodbapp.dao.EmployeeRepository;
import com.lti.training.mongodbapp.document.Employee;
import com.lti.training.mongodbapp.dto.EmployeeDto;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	// dependency
	private EmployeeRepository repository;
	
	public EmployeeController(EmployeeRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto) {
		Employee employee = new Employee(null, employeeDto.getName(), employeeDto.getEmail());
		Employee employee_new = this.repository.insert(employee);
		
		ResponseEntity<Employee> response = 
				new ResponseEntity<Employee>(employee_new, HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		
		List<Employee> employees =  this.repository.findAll();
		
		ResponseEntity<List<Employee>> response = 
				new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
		return response;
	}
	
}














