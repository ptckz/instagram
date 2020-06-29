package com.instagram.authservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.instagram.authservice.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
    List<User> findByUsernameIn(List<String> usernames);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}