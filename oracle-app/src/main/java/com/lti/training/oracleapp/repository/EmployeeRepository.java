package com.lti.training.oracleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.lti.training.oracleapp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Procedure
	void INSERT_EMPLOYEE(String name, String email, int age);
	
	@Procedure(name = "INSERT_EMPLOYEE")
	void insertNewEmployee(String name, String email, int age);
}
