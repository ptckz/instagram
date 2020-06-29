package com.instagram.feedservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import com.instagram.feedservice.entity.UserFeed;

@Repository
public interface FeedRepository extends CassandraRepository<UserFeed, String> {

	Slice<UserFeed> findByUsername(String username, Pageable pageable);
}