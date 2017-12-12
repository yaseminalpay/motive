package com.boun.motive.controller;

import com.boun.motive.model.Comment;
import com.boun.motive.service.ICommentService;

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
    ICommentService commentService;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Comment> create(@RequestBody @Valid Comment comment) {
        commentService.createComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> get(@RequestParam("contentId") String contentId) {
        return new ResponseEntity<>(commentService.getCommentsByContentId(contentId), HttpStatus.OK);
    }
}
