package com.boun.motive.repository;

import com.boun.motive.model.Interest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestMongoRepository extends MongoRepository<Interest, String> {

    List<Interest> findByUserId(String userId);
    List<Interest> findByTitleContains(String keyword);

}
