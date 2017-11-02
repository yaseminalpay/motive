package com.boun.motive.repository;

import com.boun.motive.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentMongoRepository extends MongoRepository<Content, String> {

    public List<Content> findByInterestId(String interestId);
    public List<Content> findByInterestIdAndUserId(String interestId, String userId);
}
