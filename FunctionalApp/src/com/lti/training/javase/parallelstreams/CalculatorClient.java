package com.lti.training.javase.parallelstreams;

import java.util.stream.IntStream;

public class CalculatorClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator calculator = new Calculator();
		
		// generate a stream of number
		// seq
		/*IntStream.rangeClosed(1, 1000)
			.forEach(value -> calculator.performSum(value));
		System.out.println("Sequential Sum : " + calculator.getResult());
		*/
		IntStream.rangeClosed(1, 1000).parallel()
		.forEach(value -> calculator.performSum(value));
		
		System.out.println("Parallel Sum : " + calculator.getResult());
	}

}
