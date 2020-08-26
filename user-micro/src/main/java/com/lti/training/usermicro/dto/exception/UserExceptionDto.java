package com.lti.training.usermicro.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExceptionDto {
	private String message;
	private Long timeStamp;
	private int status;
}
