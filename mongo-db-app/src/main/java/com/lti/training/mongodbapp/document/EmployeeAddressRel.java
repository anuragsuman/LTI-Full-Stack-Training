package com.lti.training.mongodbapp.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EmployeeAddressRel {

	// _id : auto will add
	private String employeeId;
	private String addressId;
}
