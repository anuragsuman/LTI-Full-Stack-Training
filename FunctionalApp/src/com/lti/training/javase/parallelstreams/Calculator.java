package com.lti.training.javase.parallelstreams;

public class Calculator {

	private int result;
	
	public int getResult() {
		return result;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
	// perform addition 
	public void performSum(int num) {
		result += num;
	}
}
