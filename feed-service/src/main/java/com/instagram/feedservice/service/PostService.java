package com.instagram.feedservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.instagram.feedservice.client.PostServiceClient;
import com.instagram.feedservice.config.JwtConfig;
import com.instagram.feedservice.exception.UnableToGetPostsException;
import com.instagram.feedservice.model.Post;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostService {

    @Autowired private PostServiceClient postServiceClient;
    @Autowired private JwtConfig jwtConfig;

    public List<Post> findPostsIn(String token, List<String> ids) {
        log.info("finding posts for ids {}", ids);

        ResponseEntity<List<Post>> response =
                postServiceClient.findPostsByIdIn(jwtConfig.getPrefix() + token, ids);

        if(response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new UnableToGetPostsException(
                    String.format("unable to get posts for ids", ids));
        }
    }
}