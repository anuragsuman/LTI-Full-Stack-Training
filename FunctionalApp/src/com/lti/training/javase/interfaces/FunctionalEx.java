package com.lti.training.javase.interfaces;

import java.util.function.Function;

public class FunctionalEx {
	
	static Function<String, String> upperCase = str -> str.toUpperCase();
	
	static Function<String, String> addSomeString = str -> str.concat("dummy");
	
	public static void main(String args[]) {
		System.out.println(upperCase.apply("Hello"));
		
		System.out.println(addSomeString.andThen(upperCase).apply("Hello"));
	}
}

// extract name and activities of all students as map whose grade > 2 and gpa >=3.5
// using max functional interfaces
