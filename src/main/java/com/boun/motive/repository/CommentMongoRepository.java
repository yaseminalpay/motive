package com.boun.motive.repository;

import com.boun.motive.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMongoRepository extends MongoRepository<Comment, String> {

    public List<Comment> findCommentsByContentId(String contentId);
}
