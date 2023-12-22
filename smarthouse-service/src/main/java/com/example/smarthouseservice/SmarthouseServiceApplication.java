package com.example.smarthouseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SmarthouseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmarthouseServiceApplication.class, args);
	}

}
