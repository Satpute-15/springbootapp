package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class RoomApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RoomApplication.class, args);
		System.out.println("Ankit Satpute");
	}

}
