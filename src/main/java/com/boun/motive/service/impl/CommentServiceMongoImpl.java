package com.boun.motive.service.impl;

import com.boun.motive.model.Comment;
import com.boun.motive.repository.CommentMongoRepository;
import com.boun.motive.service.ICommentService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceMongoImpl implements ICommentService {

    @Autowired
    CommentMongoRepository commentMongoRepository;


    @Override
    public Comment createComment(Comment comment) {
        commentMongoRepository.save(comment);
        return comment;
    }

    @Override
    public List<Comment> getCommentsByContentId(String contentId) {
        return commentMongoRepository.findCommentsByContentId(contentId);

    }
}
