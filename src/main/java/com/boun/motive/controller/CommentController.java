package com.boun.motive.controller;

import com.boun.motive.dao.ICommentDAO;
import com.boun.motive.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    ICommentDAO commentDAO;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Comment> create(@RequestBody @Valid Comment comment) {
        commentDAO.createComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> get(@RequestParam("contentId") String contentId) {
        return new ResponseEntity<>(commentDAO.getCommentsByContentId(contentId), HttpStatus.OK);
    }
}
