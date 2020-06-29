package com.instagram.feedservice.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instagram.feedservice.payload.JwtAuthenticationResponse;
import com.instagram.feedservice.payload.ServiceLoginRequest;
import com.instagram.feedservice.payload.UserSummary;


@FeignClient(serviceId = "INSTA-AUTH")
public interface AuthServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "signin")
    ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody ServiceLoginRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/users/summary/in")
    ResponseEntity<List<UserSummary>> findByUsernameIn(
            @RequestHeader("Authorization") String token,
            @RequestBody List<String> usernames);
}