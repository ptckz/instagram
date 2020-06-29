package com.instagram.feedservice.service;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.instagram.feedservice.client.AuthServiceClient;
import com.instagram.feedservice.config.JwtConfig;
import com.instagram.feedservice.exception.UnableToGetAccessTokenException;
import com.instagram.feedservice.exception.UnableToGetUsersException;
import com.instagram.feedservice.payload.JwtAuthenticationResponse;
import com.instagram.feedservice.payload.ServiceLoginRequest;
import com.instagram.feedservice.payload.UserSummary;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AuthService {

    @Autowired 
    private AuthServiceClient authClient;
    
    @Autowired 
    private ServiceLoginRequest serviceLoginRequest;
    
    @Autowired 
    private JwtConfig jwtConfig;

    public String getAccessToken() {

        ResponseEntity<JwtAuthenticationResponse> response =
                authClient.signin(serviceLoginRequest);

        if(!response.getStatusCode().is2xxSuccessful()) {
            String message = String.format("unable to get access token for service account, %s",
                    response.getStatusCode());

            log.error(message);
            throw new UnableToGetAccessTokenException(message);
        }

        return response.getBody().getAccessToken();
    }

    public Map<String, String> usersProfilePic(String token,
                                               List<String> usernames) {

        ResponseEntity<List<UserSummary>> response =
                authClient.findByUsernameIn(
                        jwtConfig.getPrefix() + token, usernames);

        if(!response.getStatusCode().is2xxSuccessful()) {
            String message = String.format("unable to get user summaries %s",
                    response.getStatusCode());

            log.error(message);
            throw new UnableToGetUsersException(message);
        }

       return response
                .getBody()
                .stream()
                .collect(toMap(UserSummary::getUsername,
                        UserSummary::getProfilePicture));
    }
}