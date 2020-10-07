package com.lti.training.usermicro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.training.usermicro.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { // , CustomUserRepository{

	User findByEmailIdAndPassword(String emailId, String password);
	
	/*@Query("select u from User where emailId LIKE = :criteria")
	User getUserOnSpecificCriteria(String criteria);*/
}

/*
	1. All CRUD functionality (default available)
	2. Add new method with correct naming convention ( implementation will be provided )
	3. Custom Query
	4. Custom interface and implementation
*/