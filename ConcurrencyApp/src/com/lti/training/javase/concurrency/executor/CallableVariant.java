package com.lti.training.javase.concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableVariant {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService executor =  Executors.newFixedThreadPool(5);
	 	
		List<Factorial> tasks = new ArrayList<Factorial>();
		tasks.add(new Factorial(20));
		tasks.add(new Factorial(25));
		tasks.add(new Factorial(30));
		tasks.add(new Factorial(35));
		tasks.add(new Factorial(40));
		
	 	// List<Future<Double>> results = executor.invokeAll(tasks);
	 	// results.get(0).get();
	 	Double result = executor.invokeAny(tasks); //blocking : till the fastest thread terminate
	}

}
