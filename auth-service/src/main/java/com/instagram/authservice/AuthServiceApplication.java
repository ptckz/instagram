package com.instagram.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.instagram.authservice.messaging.UserEventStream;

@SpringBootApplication
@EnableMongoAuditing
@EnableBinding(UserEventStream.class)
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
}