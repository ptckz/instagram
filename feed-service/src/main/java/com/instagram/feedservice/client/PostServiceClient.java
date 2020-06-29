package com.instagram.feedservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instagram.feedservice.model.Post;

import java.util.List;

@FeignClient(serviceId = "INSTA-POST")
public interface PostServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/posts/in")
    ResponseEntity<List<Post>> findPostsByIdIn(
            @RequestHeader("Authorization") String token,
            @RequestBody List<String> ids);

}