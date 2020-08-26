package com.lti.training.javase.interfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.lti.training.javase.repo.Student;
import com.lti.training.javase.repo.StudentRepository;

public class ConsumerEx {

	static Consumer<Student> nameDisplay = student -> System.out.println(student.getName());
	
	static Consumer<Student> activitiesDisplay = student -> System.out.println(student.getActivities());
	
	static Predicate<Student> filterOnGrade = student -> student.getGrade() > 2;
	
	// static Predicate<Student> filterOnGpa = student -> student.getGpa() >= 3.5;
	static Predicate<Student> filterOnGpa = ConsumerEx :: filterStudentsOnGpa;
	
	static Supplier<List<Student>> studentsFromRepository = () -> StudentRepository.getStudents();
	
	
	
	static boolean filterStudentsOnGpa(Student student) {
		if(student.getGpa() >= 3.5)
			return true;
		return false;
					
	}
	
	public static void displayNamesOfAll() {
		// forEach added with default definition
		// forEach(<Consumer>)
		// StudentRepository.getStudents().forEach(nameDisplay); // ~ accept
		studentsFromRepository.get().forEach(nameDisplay); // ~ accept
	}
	
	public static void displayNamesAndActivitiesOfAll() {
		// forEach added with default definition
		// forEach(<Consumer>)
		StudentRepository.getStudents().forEach(nameDisplay.andThen(activitiesDisplay));
	}
	
	public static void displayNamesAndActivitiesOfAllBasedOnGrade() {
		// forEach added with default definition
		// forEach(<Consumer>)
		StudentRepository.getStudents().forEach(student -> {
				/*if(student.getGrade() > 2) {
					nameDisplay.andThen(activitiesDisplay).accept(student);
				}*/
			// if(filterOnGrade.and(filterOnGpa).test(student)) {
			if(filterOnGrade.and(ConsumerEx :: filterStudentsOnGpa).test(student)) {
				nameDisplay.andThen(activitiesDisplay).accept(student);
			}
		});
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// displayNamesOfAll();
		// displayNamesAndActivitiesOfAll();
		displayNamesAndActivitiesOfAllBasedOnGrade();
		
	}

}
