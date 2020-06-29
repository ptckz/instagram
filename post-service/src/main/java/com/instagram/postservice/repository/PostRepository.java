package com.instagram.postservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.instagram.postservice.model.Post;

import java.util.List;


public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByUsernameOrderByCreatedAtDesc(String username);
    List<Post> findByIdInOrderByCreatedAtDesc(List<String> ids);
}