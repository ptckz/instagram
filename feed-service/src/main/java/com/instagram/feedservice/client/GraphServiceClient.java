package com.instagram.feedservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.instagram.feedservice.model.User;
import com.instagram.feedservice.payload.PagedResult;


@FeignClient(serviceId = "INSTA-GRAPH")
public interface GraphServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users/paginated/{username}/followers")
    ResponseEntity<PagedResult<User>> findFollowers(
            @RequestHeader("Authorization") String token,
            @PathVariable String username,
            @RequestParam int page,
            @RequestParam int size);
}