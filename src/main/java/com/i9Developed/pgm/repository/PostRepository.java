package com.i9Developed.pgm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.i9Developed.pgm.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}