package com.lti.training.javase.concurrency.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// resource
public class Counter {

	private int i;
	
	Lock lockI = new ReentrantLock();
	void incrementI() {
		// Non-Atomic activity
		// 3 step process
		lockI.lock();
		i++;
		lockI.unlock();
	}
	
	public int getI() {
		return i;
	}
}
// 1000 threads using same object of counter
// all calling increment