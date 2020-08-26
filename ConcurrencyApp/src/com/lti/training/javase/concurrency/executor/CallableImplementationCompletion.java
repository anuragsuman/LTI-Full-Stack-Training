package com.lti.training.javase.concurrency.executor;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableImplementationCompletion {
	public static void main(String args[]) throws InterruptedException, ExecutionException, TimeoutException {
	 	ExecutorService executor =  Executors.newFixedThreadPool(5);
	 	
	  	CompletionService<Double> service = new ExecutorCompletionService<Double>(executor);
	 	// can extract later on using future reference
	  	
	 	Future<Double> fact1 = service.submit(new FactorialPro(20, 5000));
	 	Future<Double> fact2 = service.submit(new FactorialPro(25, 4000));
	 	Future<Double> fact3 = service.submit(new FactorialPro(30,1000));
	 	Future<Double> fact4 = service.submit(new FactorialPro(35,2000));
	 	Future<Double> fact5 = service.submit(new FactorialPro(40,4000));
	 	
	 	for(int i = 1;i<=5;i++) {
	 		Double result = service.take() // returns the future of recently terminated thread
	 				.get(); // blocking
	 		System.out.println("Result : " + result);
	 	}
	 	
	 	
	 	executor.shutdown();
	}
}
