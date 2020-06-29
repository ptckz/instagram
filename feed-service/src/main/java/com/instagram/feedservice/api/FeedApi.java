package com.instagram.feedservice.api;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.feedservice.model.Post;
import com.instagram.feedservice.payload.SlicedResult;
import com.instagram.feedservice.service.FeedService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FeedApi {

    @Autowired 
    private FeedService feedService;

    @RequestMapping("/feed/{username}")
    public ResponseEntity<SlicedResult<Post>> getFeed(
            @PathVariable String username,
            @RequestParam(value = "ps",required = false) Optional<String> pagingState) {

        log.info("fetching feed for user {} isFirstPage {}",
                username, pagingState.empty());

        return ResponseEntity.ok(feedService.getUserFeed(username, pagingState));
    }
}