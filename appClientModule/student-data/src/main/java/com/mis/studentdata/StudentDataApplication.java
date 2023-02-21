package com.mis.studentdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDataApplication.class, args);
		System.out.println("Spring Boot app is starting..");
	}

}
