package com.lti.training.javase.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lti.training.javase.repo.Student;
import com.lti.training.javase.repo.StudentRepository;

public class TerminalEx {
	
	// group by gender
	public static void groupByGender() {
		Map<String, List<Student>>	studentMap = StudentRepository.getStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGender));
		
		System.out.println(studentMap);
	}
	
	//group by gpa values
	public static void groupByGpa() {
		
		Map<String, List<Student>>	studentMap = StudentRepository.getStudents()
				.stream()
				.collect(Collectors.groupingBy(student->student.getGpa() >= 3.5 ? "OUTSTANDING" : "AVERAGE"));
		
		System.out.println(studentMap);
	}
	
	public static void main(String args[]) {
		// groupByGender();
		groupByGpa();
	}
}
