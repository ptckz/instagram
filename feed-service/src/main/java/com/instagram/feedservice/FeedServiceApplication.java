package com.instagram.feedservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.instagram.feedservice.messaging.PostEventStream;
import com.instagram.feedservice.service.FeedService;

@SpringBootApplication
@EnableFeignClients
@EnableBinding(PostEventStream.class)
public class FeedServiceApplication {
	
	@Autowired
	FeedService service;

	public static void main(String[] args) {
		SpringApplication.run(FeedServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}