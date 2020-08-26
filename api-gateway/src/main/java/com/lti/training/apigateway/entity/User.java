package com.lti.training.apigateway.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	private String username;
	private String password;
	private boolean enabled;
	
	// bussiness logic flds
}
