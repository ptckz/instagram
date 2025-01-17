package com.instagram.feedservice.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class ServiceLoginRequest {

    @Value("${security.service.username}")
    private String username;

    @Value("${security.service.password}")
    private String password;
}