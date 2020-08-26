package com.lti.training.bootapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lti.training.bootapp.entity.Student;

@Controller
public class HomeController {

	@GetMapping("/student")
	public String home(Model model) {
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("First", "first@mail.com"));
		students.add(new Student("Second", "second@mail.com"));
		students.add(new Student("Third", "third@mail.com"));
		students.add(new Student("Fourth", "fourth@mail.com"));
		
		model.addAttribute("students",students);
		
		return "index";
	}
}
