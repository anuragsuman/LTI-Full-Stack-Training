package com.lti.training.oracleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.oracleapp.entity.Employee;
import com.lti.training.oracleapp.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeRepository repository;
	
	@Autowired
	public EmployeeController(EmployeeRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> add(@RequestBody Employee employee){
		
		Employee employee_added = this.repository.save(employee);
		// this.repository.INSERT_EMPLOYEE(employee.getName(), employee.getEmail(), employee.getAge());
		ResponseEntity<Employee> response = 
				new ResponseEntity<Employee>(employee_added, HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAll(){
		 List<Employee> employees =  this.repository.findAll();
		 ResponseEntity<List<Employee>> response = 
				 new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		 
		 return response;
	}
	
	
}









