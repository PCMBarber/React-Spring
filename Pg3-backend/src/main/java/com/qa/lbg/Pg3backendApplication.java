package com.qa.lbg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Pg3backendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pg3backendApplication.class, args);
	}

//	@GetMapping("/hello")
//	public String greeting() {
//		return "Hello, World!";
//	}

}