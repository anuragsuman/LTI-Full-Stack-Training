package com.lti.training.usermicro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lti.training.usermicro.dto.exception.UserExceptionDto;

@RestControllerAdvice  // AOP API 
public class UserGlobalExceptionHandler {
	
	@ExceptionHandler(UserConstraintException.class)
	public ResponseEntity<UserExceptionDto> handleConstraintException(UserConstraintException ex) {
		UserExceptionDto exception = 
				new UserExceptionDto(ex.getMessage(),
						System.currentTimeMillis(), 
						HttpStatus.BAD_REQUEST.value());
		ResponseEntity<UserExceptionDto> response =
				new ResponseEntity<UserExceptionDto>(exception, HttpStatus.BAD_REQUEST);
		return response;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<UserExceptionDto> handleException(Exception ex) {
		UserExceptionDto exception = 
				new UserExceptionDto(ex.getMessage(),
						System.currentTimeMillis(), 
						HttpStatus.BAD_REQUEST.value());
		ResponseEntity<UserExceptionDto> response =
				new ResponseEntity<UserExceptionDto>(exception, HttpStatus.BAD_REQUEST);
		return response;
	}
	
}
