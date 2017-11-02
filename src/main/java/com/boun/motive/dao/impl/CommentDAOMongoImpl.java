package com.boun.motive.dao.impl;

import com.boun.motive.dao.ICommentDAO;
import com.boun.motive.model.Comment;
import com.boun.motive.repository.CommentMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentDAOMongoImpl implements ICommentDAO {

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
