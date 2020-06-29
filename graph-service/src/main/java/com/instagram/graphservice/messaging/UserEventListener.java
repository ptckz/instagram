package com.instagram.graphservice.messaging;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.instagram.graphservice.model.User;
import com.instagram.graphservice.payload.UserEventPayload;
import com.instagram.graphservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserEventListener {

    private UserService userService;

    public UserEventListener(UserService userService) {
        this.userService = userService;
    }

    @StreamListener(UserEventStream.INPUT)
    public void onMessage(Message<UserEventPayload> message) {

        UserEventType eventType = message.getPayload().getEventType();

        log.info("received message to process user {} eventType {}",
                message.getPayload().getUsername(),
                eventType.name());

        Acknowledgment acknowledgment =
                message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);

        User user = convertTo(message.getPayload());

        switch (eventType) {
            case CREATED:
                userService.addUser(user);
                break;
            case UPDATED:
                userService.updateUser(user);
                break;
        }

        if(acknowledgment != null) {
            acknowledgment.acknowledge();
        }
    }

    private User convertTo(UserEventPayload payload) {
        return User
                .builder()
                .userId(payload.getId())
                .username(payload.getUsername())
                .name(payload.getDisplayName())
                .profilePic(payload.getProfilePictureUrl())
                .build();
    }
}