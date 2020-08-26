package com.lti.training.javase.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.lti.training.javase.repo.Student;
import com.lti.training.javase.repo.StudentRepository;

public class ExploreStream {

	static Predicate<Student> filterOnGrade = student -> student.getGrade() > 2;
	
	static Predicate<Student> filterOnGpa = student -> student.getGpa() >= 3.5;
	
	public static void main(String args[]) {
	 	/*List<Student> filteredStudents = StudentRepository.getStudents()
			.stream().peek(student -> System.out.println("Initiated : " + student))
			.filter(filterOnGrade).peek(student -> System.out.println("Ist Filter : " + student))
			// .filter(filterOnGrade.and(filterOnGpa)) // return another stream 
			.filter(filterOnGpa).peek(student -> System.out.println("IInd Filter : " + student)) 
			.collect(Collectors.toList());
			//.forEach(System.out::println);*/
		
			Map<String, List<String>> studentMap= StudentRepository.getStudents()
				.stream().peek(student -> System.out.println("Initiated : " + student))
				.filter(filterOnGrade).peek(student -> System.out.println("Ist Filter : " + student))
				// .filter(filterOnGrade.and(filterOnGpa)) // return another stream 
				.filter(filterOnGpa).peek(student -> System.out.println("IInd Filter : " + student)) 
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
				
				// .collect(Collectors.toList());
				//.forEach(System.out::println);
				// peek(<Consumer>)
		
	 	
	 	System.out.println("\n\nFinal Data");
	 	// System.out.println(filteredStudents);
	 	System.out.println(studentMap);	
	 	
	 	
	 	StudentRepository.getStudents()
		.stream().peek(student -> System.out.println("Initiated : " + student))
		.filter(filterOnGrade).peek(student -> System.out.println("Ist Filter : " + student))
		// .filter(filterOnGrade.and(filterOnGpa)) // return another stream 
		.filter(filterOnGpa).peek(student -> System.out.println("IInd Filter : " + student)); 
		
	 	
			
	}
}
