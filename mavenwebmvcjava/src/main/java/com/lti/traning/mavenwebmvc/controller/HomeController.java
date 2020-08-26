package com.lti.traning.mavenwebmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.traning.mavenwebmvc.entity.Student;

@Controller
public class HomeController {
	
	// service method
	// each service method will be mapped to a particular URL
	// String :to return view page name
	// need to map url + http method (verb)
	@GetMapping("/")
	// @RequestMapping("/") // support all http verb
	// @RequestMapping(value = "/", method = RequestMethod.GET) // support all http verb
	public String home() {
		// logic to process request
		
		// return view page name back
		return "index";
	}
	
	@GetMapping("/student")
	// public String studentData(HttpServletRequest request, HttpServletResponse response) {
	public String studentData(Model model) {
		// logic to process request
		Student student = new Student("First", "first@mailcom");
		model.addAttribute("student", student);
		// return view page name back
		return "student-view";
	}
}















