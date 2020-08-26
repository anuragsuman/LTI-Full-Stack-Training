package com.lti.training.javase.concurrency.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompleatableFutureImpl {

	public static void main(String[] args) throws InterruptedException {
		
		Supplier<Double> factorialSupplier = new FactorialSupplier(20);
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		// launches the task as thread
		CompletableFuture<Double> factorialFuture = 
				CompletableFuture.supplyAsync(factorialSupplier, executor)
				.exceptionally(ex -> {
					if (ex instanceof InterruptedException) {
						
					}
					if(ex instanceof Exception) {
						
					}
					return 0.0; 
				});// for returning values
				// CompletableFuture.runAsync(runnable); // does not return anything
		
		factorialFuture.thenAccept(factorial -> System.out.println("Factorial value :" + factorial));
		
		System.out.println("Call back already associated..");
		
		while(!factorialFuture.isDone());
	}
}
