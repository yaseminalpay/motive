package com.boun.motive.dao;

import com.boun.motive.model.Comment;

import java.util.List;

public interface ICommentDAO {

    public void createComment(Comment comment);
    public List<Comment> getCommentsByContentId(String contentId);

}
