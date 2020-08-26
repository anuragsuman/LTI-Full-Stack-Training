package com.lti.training.javase.concurrency.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableImplementation {
	public static void main(String args[]) throws InterruptedException, ExecutionException, TimeoutException {
	 	ExecutorService executor =  Executors.newFixedThreadPool(5);
	 	
	 	// can extract later on using future reference
	 	Future<Double> fact1 = executor.submit(new Factorial(20));
	 	Future<Double> fact2 = executor.submit(new Factorial(25));
	 	Future<Double> fact3 = executor.submit(new Factorial(30));
	 	Future<Double> fact4 = executor.submit(new Factorial(35));
	 	Future<Double> fact5 = executor.submit(new Factorial(40));
	 	
	 	// whenever you need them
	 	// fact1.get(); // blocked : if the thread is still running
	 	// System.out.println("Factorial of 20 :" + fact1.get(timeout, unit));
	 	// System.out.println("Factorial of 20 :" + fact1.get(10L,TimeUnit.SECONDS));
	 	System.out.println("Factorial of 20 :" + fact1.get());
	 	System.out.println("Factorial of 25 :" + fact2.get());
	 	System.out.println("Factorial of 30 :" + fact3.get());
	 	System.out.println("Factorial of 35 :" + fact4.get());
	 	System.out.println("Factorial of 40 :" + fact5.get());
	 	
	 	executor.shutdown();
	}
}
