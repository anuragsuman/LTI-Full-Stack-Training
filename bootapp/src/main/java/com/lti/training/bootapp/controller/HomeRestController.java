package com.lti.training.bootapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.bootapp.entity.Student;

@RestController
@RequestMapping("/rest") // all type request would be accepted
public class HomeRestController {

	
	@GetMapping("/student")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("First", "first@mail.com"));
		students.add(new Student("Second", "second@mail.com"));
		students.add(new Student("Third", "third@mail.com"));
		students.add(new Student("Fourth", "fourth@mail.com"));
		
		return students;
	}
	
	/*
	// /rest/test
	@GetMapping("/test")
	xyz()
	
	// /rest/test
	@PostMapping("/test")
	xyz()
	
	@Deleteapping("/test")
	xyz()
	
	
	// /rest/trial
	@PostMapping("/trial")
	abc()
	*/
}
