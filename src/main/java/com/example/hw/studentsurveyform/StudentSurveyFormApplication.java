package com.example.hw.studentsurveyform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Combines @Configuration, @EnableAutoConfiguration, @ComponentScan
public class StudentSurveyFormApplication {

	public static void main(String[] args) {
		// Launches the Spring Boot app
		SpringApplication.run(StudentSurveyFormApplication.class, args);
	}
}
