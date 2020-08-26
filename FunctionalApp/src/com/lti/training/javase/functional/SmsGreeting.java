/**
 * 
 */
package com.lti.training.javase.functional;

/**
 * @author DELL
 *
 */
public class SmsGreeting implements Greeting {

	@Override
	public void sendGreeting(String message) {
		// TODO Auto-generated method stub
		System.out.println("Sending SMS : " + message);
	}

}
