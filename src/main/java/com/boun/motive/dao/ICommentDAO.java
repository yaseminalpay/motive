package com.boun.motive.dao;

import com.boun.motive.model.Comment;

import java.util.List;

public interface ICommentDAO {

    Comment createComment(Comment comment);
    List<Comment> getCommentsByContentId(String contentId);

}
