package com.instagram.feedservice.exception;

public class UnableToGetPostsException extends RuntimeException {

    public UnableToGetPostsException(String message) {
        super(message);
    }
}