package com.lti.training.javase.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;

import com.lti.training.javase.repo.Student;
import com.lti.training.javase.repo.StudentRepository;

public class ParallelStreamEx {

	
	// sequential stream
	public static List<String> seqStream(){
		long start = System.currentTimeMillis();
		
		List<String> activities = StudentRepository.getStudents()
				.stream().peek(student->System.out.println("Stream : " + student))  // Stream<Student>
				.map(Student::getActivities).peek(list -> System.out.println("MAP : " + list)) // Stream<List<String>>
				.flatMap(List::stream).peek(activity -> System.out.println("FLAT MAP : " + activity)) // Stream<String>
				.distinct().peek(activity-> System.out.println("DISTINCT : " + activity))
				.collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Sequential : " + diff);
		return activities;
	}
	
	// parallel stream
	public static List<String> parallelStream(){
		
		long start = System.currentTimeMillis();
		
		// streams are blocking
		List<String> activities = StudentRepository.getStudents()
				.parallelStream().peek(student->System.out.println("Stream : " + student))  // Stream<Student>
				.map(Student::getActivities).peek(list -> System.out.println("MAP : " + list)) // Stream<List<String>>
				.flatMap(List::stream).peek(activity -> System.out.println("FLAT MAP : " + activity)) // Stream<String>
				.distinct().peek(activity-> System.out.println("DISTINCT : " + activity))
				.collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Parallel: " + diff);
		return activities;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n\nSequential List :\n" + seqStream());
		System.out.println("\n\nParallel List :\n" + parallelStream());
	}

}
