package com.example.automator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.nlogo.app.App;

@SpringBootApplication
public class AutomatorApplication {

	public static void main(String[] args) {
		App.main(args);
		SpringApplication.run(AutomatorApplication.class, args);
	}
}
