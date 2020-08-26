package com.lti.training.javase.functional;

public class EmailGreeting implements Greeting {

	@Override
	public void sendGreeting(String message) {
		// TODO Auto-generated method stub
		System.out.println("Sending Email : " + message);
	}

}
