package com.lti.training.javase.concurrency.executor;

import java.time.LocalDateTime;

public class FetchDataFromFile implements Runnable{ // extends Thread

	private String fileName;
	
	public FetchDataFromFile(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	// task : pure task
	// Thread : controlling method inside it (task wrapped in a controlled env)
	@Override
	public void run() {
		try {
			System.out.println("Fetching data from " + fileName + " by " + Thread.currentThread().getName() + " | Start Time: " + LocalDateTime.now());
			// read from file
			Thread.sleep(5000);
			System.out.println("File read successfull: " + fileName + " by " + Thread.currentThread().getName() + " | End Time: " + LocalDateTime.now());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
