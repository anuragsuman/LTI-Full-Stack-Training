package com.lti.training.javase.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionVsStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		
		names.add("First");
		names.add("Second");
		names.add("Third");
		names.add("Fourth");
		names.add("Fifth");

		// mutable
		// external iteration
		for(String name : names) {
			System.out.println(name);
		}
		
		// internal iteration
		names.forEach(System.out::println);
		
		System.out.println("Stream way....\n\n");
		Stream<String> namesStream = names.stream();
		
		namesStream.forEach(System.out::println);
		
		// stream are create to be used only once : not reusable
		namesStream.forEach(System.out::println);
	}

}
