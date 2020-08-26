package com.lti.training.usermicro.dto;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDto {
	private String name;
	private String emailId;
	@Length(min = 6)
	private String password;
	private String confirmPassword;
}
