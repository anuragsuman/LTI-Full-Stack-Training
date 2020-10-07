package com.lti.training.usermicro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.usermicro.dto.LoginDto;
import com.lti.training.usermicro.dto.RegisterDto;
import com.lti.training.usermicro.dto.UserDetailDto;
import com.lti.training.usermicro.exception.UserConstraintException;
import com.lti.training.usermicro.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<UserDetailDto> register(@Valid @RequestBody RegisterDto registerDto, BindingResult result) {
		if(result.hasErrors()) {
			throw new UserConstraintException("Invalid Registration data!!!");
		}
		UserDetailDto userDetailDto =  this.userService.register(registerDto);
		ResponseEntity<UserDetailDto> response = 
				new ResponseEntity<UserDetailDto>(userDetailDto, HttpStatus.OK);
		return response;
	}

	@PostMapping("/login")
	public ResponseEntity<UserDetailDto> login(@Valid @RequestBody LoginDto loginDto, BindingResult result) {
		if(result.hasErrors()) {
			throw new UserConstraintException("Invalid Login !");
		}
		UserDetailDto userServiceDto =  this.userService.login(loginDto);
		ResponseEntity<UserDetailDto> response = 
				new ResponseEntity<UserDetailDto>(userServiceDto, HttpStatus.OK);
		return response;
	}

	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDetailDto> getUserDetail(@PathVariable Integer userId){
		UserDetailDto userDetailDto = this.userService.getUserDetail(userId);
		ResponseEntity<UserDetailDto> response = 
				new ResponseEntity<UserDetailDto>(userDetailDto, HttpStatus.OK);
		return response;
	}

}






