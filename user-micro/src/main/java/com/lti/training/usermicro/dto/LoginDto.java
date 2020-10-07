package com.lti.training.usermicro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {
	
	private String emailId;
	private String password;	
	

}
