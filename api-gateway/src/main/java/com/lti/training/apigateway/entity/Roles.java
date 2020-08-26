package com.lti.training.apigateway.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="authorities")
@Data
public class Roles {

	@Id
	private String username;
	
	@Id
	@Column(name="authority")
	private String role;
}
