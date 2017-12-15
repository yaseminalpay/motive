package com.boun.motive.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boun.motive.model.Comment;
import com.boun.motive.model.Content;
import com.boun.motive.service.IContentService;
import com.boun.motive.util.constant.Privacy;

@RestController
@RequestMapping("api/v1/contents")
public class ContentController {

    @Autowired
    private IContentService contentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Content> create(@RequestBody @Valid Content content) {
        contentService.createContent(content);
        return new ResponseEntity<>(content, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Content>> get() {
        return new ResponseEntity<>(contentService.getAllContents(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Content> get(@PathVariable("id") String id) {
        return new ResponseEntity<>(contentService.getContentById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/interest/{interestId}")
    public ResponseEntity<List<Content>> getByInterest(@PathVariable(value = "interestId", required = true) String interestId) {
        return new ResponseEntity<>(contentService.getContentsByInterest(interestId), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/comment")
    public ResponseEntity<Content> comment(@PathVariable("id") String id, @RequestBody Comment comment) {
        return new ResponseEntity<>(contentService.comment(id, comment), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/tag/{tag}")
    public ResponseEntity<Content> tag(@PathVariable("id") String id, @PathVariable("tag") String tag) {
        return new ResponseEntity<>(contentService.tagContent(id, tag), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}/tag/{tag}")
    public ResponseEntity<Content> removeTag(@PathVariable("id") String id, @PathVariable("tag") String tag) {
        return new ResponseEntity<>(contentService.removeTagFromContent(id, tag), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/privacy/{privacy}")
    public ResponseEntity<Content> modifyPrivacy(@PathVariable("id") String id, @PathVariable("privacy") Privacy privacy) {
        return new ResponseEntity<>(contentService.modifyContentPrivacy(id, privacy), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/upVote")
    public ResponseEntity<Content> upVote(@PathVariable("id") String id) {
        return new ResponseEntity<>(contentService.upVoteContent(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/downVote")
    public ResponseEntity<Content> downVote(@PathVariable("id") String id) {
        return new ResponseEntity<>(contentService.downVoteContent(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        contentService.deleteContent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
