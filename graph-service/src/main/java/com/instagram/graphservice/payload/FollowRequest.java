package com.instagram.graphservice.payload;

import lombok.Data;

@Data
public class FollowRequest {

    UserPayload follower;
    UserPayload following;
}