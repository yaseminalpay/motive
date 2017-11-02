package com.boun.motive.controller;

import com.boun.motive.dao.IContentDAO;
import com.boun.motive.model.Content;
import com.boun.motive.util.constant.Privacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/contents")
public class ContentController {

    @Autowired
    private IContentDAO contentDAO;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Content> create(@RequestBody @Valid Content content) {
        contentDAO.createContent(content);
        return new ResponseEntity<Content>(content, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Content get(@PathVariable("id") String id) {
        return contentDAO.getContentById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/interest/{interestId}")
    public List<Content> getByInterest(@PathVariable("interestId") String interestId) {
        return contentDAO.getContentsByInterest(interestId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/interest/{interestId}/user/{userId}")
    public List<Content> getByInterestAndUser(@PathVariable("interestId") String interestId, @PathVariable("userId") String userId) {
        return contentDAO.getContentsByInterestAndUser(interestId, userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/tag/{tag}")
    public void tag(@PathVariable("id") String id, @PathVariable("tag") String tag) {
        contentDAO.tagContent(id, tag);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/privacy/{privacy}")
    public void modifyPrivacy(@PathVariable("id") String id, @PathVariable("privacy") Privacy privacy) {
        contentDAO.modifyContentPrivacy(id, privacy);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/upVote")
    public void upVote(@PathVariable("id") String id) {
        contentDAO.upVoteContent(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/downVote")
    public void downVote(@PathVariable("id") String id) {
        contentDAO.downVoteContent(id);
    }








}
