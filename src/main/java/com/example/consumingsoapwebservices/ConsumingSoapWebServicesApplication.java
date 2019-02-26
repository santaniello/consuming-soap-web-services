package com.example.consumingsoapwebservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingSoapWebServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumingSoapWebServicesApplication.class, args);
	}
	@Bean
	CommandLineRunner lookup(CorreioClient correioClient) {
		return args -> {
			correioClient.calcula();
		};
	}
}
