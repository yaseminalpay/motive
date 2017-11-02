package com.boun.motive.controller;

import com.boun.motive.dao.IInterestDAO;
import com.boun.motive.model.Interest;
import com.boun.motive.util.constant.Privacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/interests")
public class InterestController {

    @Autowired
    IInterestDAO interestDAO;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Interest> create(@RequestBody @Valid Interest interest) {
        interestDAO.createInterest(interest);
        return new ResponseEntity<>(interest, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<Interest>> get() {
        return new ResponseEntity<>(interestDAO.getInterests(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Interest>> get(@RequestParam("userId") String userId ) {
        return new ResponseEntity<>(interestDAO.getInterestsByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/q")
    public ResponseEntity<List<Interest>> search(@RequestParam String keyword) {
        return new ResponseEntity<>(interestDAO.getInterestByKeyword(keyword), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/privacy/{privacy}")
    public ResponseEntity<Interest> modifyPrivacy(@PathVariable("id") String id, @PathVariable("privacy") Privacy privacy) {
        return new ResponseEntity<>(interestDAO.modifyInterestPrivacy(id, privacy), HttpStatus.OK);
    }



}
