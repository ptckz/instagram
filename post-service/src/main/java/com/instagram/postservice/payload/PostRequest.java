package com.instagram.postservice.payload;

import lombok.Data;

@Data
public class PostRequest {

    private String imageUrl;
    private String caption;
}