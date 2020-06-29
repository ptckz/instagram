package com.instagram.mediaservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.instagram.mediaservice.model.ImageMetadata;

public interface ImageMetadataRepository extends MongoRepository<ImageMetadata, String> {

}