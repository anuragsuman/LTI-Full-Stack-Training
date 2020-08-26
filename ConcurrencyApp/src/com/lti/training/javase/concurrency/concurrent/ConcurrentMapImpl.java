package com.lti.training.javase.concurrency.concurrent;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapImpl {

	public static void main(String args[]) {
		ConcurrentHashMap<String, String> capitals =
				new ConcurrentHashMap<String, String>();
		
		capitals.put("India", "Delhi");
		capitals.put("Japan", "Tokyo");
		
		Iterator<String> iterator =  capitals.keySet().iterator();
		 
	}
}
