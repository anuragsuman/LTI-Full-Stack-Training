package com.lti.training.javase.concurrency.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtomic {

	private AtomicInteger i = new AtomicInteger();
	
	public void incrementI() {
		i.incrementAndGet();
		// i.getAndIncrement();
	}
}
