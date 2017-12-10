package com.boun.motive.service;

import com.boun.motive.model.Comment;

import java.util.List;

public interface ICommentService {

    Comment createComment(Comment comment);
    List<Comment> getCommentsByContentId(String contentId);

}
