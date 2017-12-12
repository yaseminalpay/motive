package com.boun.motive.controller;

import com.boun.motive.model.Content;
import com.boun.motive.service.IContentService;
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
    private IContentService contentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Content> create(@RequestBody @Valid Content content) {
        contentService.createContent(content);
        return new ResponseEntity<>(content, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Content> get(@PathVariable("id") String id) {
        return new ResponseEntity<>(contentService.getContentById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Content>> getByInterest(@RequestParam(value = "interestId", required = true) String interestId) {
        return new ResponseEntity<>(contentService.getContentsByInterest(interestId), HttpStatus.OK);
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

}
