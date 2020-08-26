package com.lti.training.javase.stylecomparision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// Remove duplicates from a list of integers
		List<Integer> numList = Arrays.asList(1,2,3,4,4,5,5,5,6,7,7,8,9,9);
		
		// Imperative
		List<Integer> uniqueList = new ArrayList<Integer>();
		for(Integer val : numList) {
			if(!uniqueList.contains(val)) {
				uniqueList.add(val);
			}
		}
		
		System.out.println("Unique List : " + uniqueList);
		
		// Declarative
		List<Integer> uniqueListPro = numList.stream().distinct().collect(toList());
		System.out.println("Unique List : " + uniqueListPro);		
	}

}
