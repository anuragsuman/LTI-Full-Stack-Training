package com.lti.training.javase.concurrency.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class RejectHandler implements RejectedExecutionHandler{

	// reference of task rejected
	// thread pool executor
	@Override
	public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		FetchDataFromFile fetch = (FetchDataFromFile) task;
		System.out.println("Sorry! Could not read file :" + fetch.getFileName());
	}
	
}

public class ThreadPoolExecutorFixedCustom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int coreSize = 1;
		final int maxSize = 2;
		final int queueCapacity = 4;
		final long keepAliveTime = 10L;
		
		ThreadFactory factory = Executors.defaultThreadFactory();
		RejectHandler rejectHandler = new RejectHandler();
		BlockingQueue queue = new LinkedBlockingQueue(queueCapacity);
		
		
		/*ThreadPoolExecutor executor = new ThreadPoolExecutor(
				corePoolSize, 
				maximumPoolSize, 
				keepAliveTime, 
				unit, 
				workQueue, 
				threadFactory, 
				handler)*/
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				coreSize, 
				maxSize, 
				keepAliveTime, 
				TimeUnit.MILLISECONDS, 
				queue, 
				factory, 
				rejectHandler);
		
		for(int i=1;i<=10;i++) {
			FetchDataFromFile fetch = new FetchDataFromFile("File-" + i);
			// submit the task to thread pool
			executor.execute(fetch);  // any implementation of Runnable
		}
		
		// shutdown the executor
		executor.shutdown();

	}

}
