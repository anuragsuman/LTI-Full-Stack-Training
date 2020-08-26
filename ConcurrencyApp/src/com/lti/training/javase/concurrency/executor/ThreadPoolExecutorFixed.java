package com.lti.training.javase.concurrency.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorFixed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		
		for(int i=1;i<=10;i++) {
			FetchDataFromFile fetch = new FetchDataFromFile("File-" + i);
			// submit the task to thread pool
			executor.execute(fetch);  // any implementation of Runnable
		}
		
		// f1,f2,f3,f4,f5
		// f3.join(); //  block main till f3 terminates
		// shutdown the executor
		executor.shutdown();
	}

}
