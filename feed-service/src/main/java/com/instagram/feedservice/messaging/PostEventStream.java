package com.instagram.feedservice.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PostEventStream {

    String INPUT = "momentsPostChanged";

    @Input(INPUT)
    SubscribableChannel momentsPostChanged();
}