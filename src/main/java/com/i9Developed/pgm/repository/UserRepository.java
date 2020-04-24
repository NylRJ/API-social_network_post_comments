package com.i9Developed.pgm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.i9Developed.pgm.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
