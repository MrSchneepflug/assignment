package com.prisonpony.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication {
	public static void main(final String[] args) {
		final SpringApplication app = new SpringApplication(AssignmentApplication.class);
		app.run(args);
	}
}
