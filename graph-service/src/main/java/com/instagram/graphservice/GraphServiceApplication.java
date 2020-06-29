package com.instagram.graphservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.instagram.graphservice.messaging.UserEventStream;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(UserEventStream.class)
public class GraphServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphServiceApplication.class, args);
	}
}