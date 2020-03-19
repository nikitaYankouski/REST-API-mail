package com.hudman.RestApiMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestApiMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiMailApplication.class, args);
	}

}
