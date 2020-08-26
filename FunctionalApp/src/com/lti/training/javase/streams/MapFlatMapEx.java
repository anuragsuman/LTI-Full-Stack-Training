package com.lti.training.javase.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.lti.training.javase.repo.Student;
import com.lti.training.javase.repo.StudentRepository;

public class MapFlatMapEx {

	// extract the activites
	public static void getActivities() {
		/* List<List<String>> activities = StudentRepository.getStudents()
			.stream()  // Stream<Student>
			// passing student to map and getting the activities
			.map(student->student.getActivities()) // Stream<List<String>>
			.collect(Collectors.toList());
			*/
		/*List<String> activities = StudentRepository.getStudents()
				.stream()  // Stream<Student>
				// passing student to map and getting the activities
				// .map(student->student.getActivities()) // Stream<List<String>>
				.map(Student::getActivities) 
				// List<List<String>> --- List<String>
				// for each list stream of string
				//.flatMap(activites -> activities.stream())
				.flatMap(List::stream) // Stream<String>
				.distinct()
				
				.collect(Collectors.toList());*/
		
		
			// System.out.println(activities);
		long count = StudentRepository.getStudents()
		.stream()  // Stream<Student>
		// passing student to map and getting the activities
		// .map(student->student.getActivities()) // Stream<List<String>>
		.map(Student::getActivities) 
		// List<List<String>> --- List<String>
		// for each list stream of string
		//.flatMap(activites -> activities.stream())
		.flatMap(List::stream) // Stream<String>
		.filter(activity -> activity.startsWith("S"))
		.distinct()
		.count();
		System.out.println("Number of activities : " + count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getActivities();
	}

}
