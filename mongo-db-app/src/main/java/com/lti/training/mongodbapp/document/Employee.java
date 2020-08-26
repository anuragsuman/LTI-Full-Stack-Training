package com.lti.training.mongodbapp.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class Employee {

	@Id
	private String id;
	private String name;
	// @Id
	private String email;
	// embedded doc
	//private Address[] addresses;
	// ids of address documents from another collection
	private String []address;
	
}
