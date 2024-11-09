package com.FarmCollector.farmAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FarmApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(FarmApiApplication.class, args);
		System.out.println("Starting Farm API");
	}

}
