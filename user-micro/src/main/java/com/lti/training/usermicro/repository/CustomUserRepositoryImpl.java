package com.lti.training.usermicro.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.training.usermicro.entity.User;

public class CustomUserRepositoryImpl implements CustomUserRepository {

	// Hibernate : JPA
	
	/*@Autowired
	SessionFactory sessionFactory;*/
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User someComplexDbRequirement(String param) {
		// TODO Auto-generated method stub
		// JPA native 
		// this.entityManager.
		Session session = entityManager.unwrap(Session.class);
		return null;
		
	}

}
