package com.instagram.feedservice.payload;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

import com.instagram.feedservice.messaging.PostEventType;

@Data
@Builder
public class PostEventPayload {

    private String id;
    private Instant createdAt;
    private Instant updatedAt;
    private String username;
    private String lastModifiedBy;
    private String imageUrl;
    private String caption;
    private PostEventType eventType;

}