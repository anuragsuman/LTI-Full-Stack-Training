package com.lti.training.bootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootApplication(scanBasePackages = {"com.lti.training.bootapp", "com.external.thirdparty"})
public class BootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootappApplication.class, args);
	}
	
	// also configuration a file

}
