package com.example.hackerbills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.example.hackerbills.*" })

public class HackerBillsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackerBillsApplication.class, args);
	}

}
