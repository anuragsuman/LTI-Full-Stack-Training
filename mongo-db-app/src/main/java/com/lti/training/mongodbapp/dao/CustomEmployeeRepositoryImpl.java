package com.lti.training.mongodbapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.mongodbapp.document.Employee;

public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository {

	// will be auto injected
	@Autowired
	MongoTemplate mongoTemplate; // ~ EntityManager
	
	@Transactional
	@Override
	public void someComplexLogic() {
		// TODO Auto-generated method stub
		Employee empl1 = new Employee(null,"First","first@mail.com");
		Employee empl2 = new Employee(null,"Second","first@mail.com");
		Employee empl3 = new Employee(null,"Third","first@mail.com");
		Employee empl4 = new Employee(null,"Fourth","first@mail.com");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(empl1);
		employees.add(empl2);
		employees.add(empl3);
		employees.add(empl4);
		this.mongoTemplate.insert(employees, Employee.class , ""); 
		
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is("first@mail.com"));
		// by default going to search records(Document) in employee collection
		this.mongoTemplate.find(query, Employee.class);
		// this.mongoTemplate.find(query, Employee.class,"collectionname"); searches intthat collectionname
		
		Query querypro = new Query();
		querypro.addCriteria(Criteria.where("email").is("first@mail.com").andOperator(Criteria.where("age").is(20)));
		Update update = new Update();
		update.set("name", "Dummy");
		update.set("age", 20);
		this.mongoTemplate.updateFirst(querypro, update, Employee.class);
		
		
	}

}
