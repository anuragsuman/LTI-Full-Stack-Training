package com.lti.training.mongodbapp.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
	
	@Id
	private String id;
	private String location;
	private String lane;
	private int plot;
	
}
