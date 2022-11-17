package com.bdtest.TestBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestBdApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBdApplication.class, args);
	}


}
