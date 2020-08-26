package com.lti.training.javase.concurrency.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CommonResource{
	private String names[];
	
	Lock myLock = new ReentrantLock();
	
	synchronized static void manageArray() {
		// Read and write operation
		// CommonResource 
	}
	
	synchronized  static void changeArray() {
		// Read and write operation
	}
	
	void testArray() {
		// ---------
		// --------
		synchronized(this) { 
			m1();
		}
		myLock.
		//--------
		//--------
		//--------
		//--------
		myLock.unlock();
		
		//--------
	}
}


class Thread1 extends Thread{
	public void run() {
		synchronized(CommonResource.class) {
			
		}
		synchronized(obj1) {
			// -----------
			// ----------
			// ----------
		}
	}
}

public class CommonResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
