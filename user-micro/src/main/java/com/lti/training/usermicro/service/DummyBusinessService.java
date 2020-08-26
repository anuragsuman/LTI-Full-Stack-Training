package com.lti.training.usermicro.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.training.usermicro.repository.DummyRepository;

public class DummyBusinessService {

	// dependency on repository
	// @Autowired
	private DummyRepository repository;
	
	public void setRepository(DummyRepository repository) {
		this.repository = repository;
	}
	
	public int calculateSum(int[] data) {
		/*int sum = 0;
		for(int val : data) {
			sum += val;
		}
		return sum;*/
		// Functional Style
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
	
	public int calculateSumFromRepository() {
		// Functional Style
		int data[] = this.repository.getNumbersFromDB();
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
	
	private int sum(int a, int b) {
		return a+b;
	}
	
	
}















