package com.boun.motive.repository;

import com.boun.motive.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String>{

    User findUserByUsername(String username);
}
