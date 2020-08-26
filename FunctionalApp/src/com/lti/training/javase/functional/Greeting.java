package com.lti.training.javase.functional;


@FunctionalInterface  // compile time
public interface Greeting {
	void sendGreeting(String message);
	default void fun() {
		
	}
}
