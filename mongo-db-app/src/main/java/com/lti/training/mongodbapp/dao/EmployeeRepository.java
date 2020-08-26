package com.lti.training.mongodbapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lti.training.mongodbapp.document.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>, CustomEmployeeRepository{
	
}
