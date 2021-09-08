package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootProductAppApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringBootProductAppApplication.class);
//		springApplication.setAdditionalProfiles("native");
		springApplication.run(args);
	}
	
	@GetMapping("/revatureTraining")
	public String revatureTraining() {
		return "Welcome to revature training - Tufail Ahmed";
	}
	@GetMapping("/mockInterviews")
	public String mock() {
		return "Welcome to Mock Interviews 1 and 2";
	}
	@GetMapping
	public String stated() {
		return "Welcome to Product app";
	}

}
