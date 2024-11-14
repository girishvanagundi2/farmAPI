package com.FarmCollector.farmAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FarmApiApplication {

	public static void main(String[] args) {

		ApplicationContext app = SpringApplication.run(FarmApiApplication.class, args);
		System.out.println("Starting Farm API");


	}

}
