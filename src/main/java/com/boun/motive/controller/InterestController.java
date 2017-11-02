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
        return new ResponseEntity<Interest>(interest, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Interest> get() {
        return interestDAO.getInterests();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public List<Interest> get(@PathVariable("userId") String userId ) {
        return interestDAO.getInterestsByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/q")
    public List<Interest> search(@RequestParam String keyword) {
        return interestDAO.getInterestByKeyword(keyword);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/modifyPrivacy/{privacy}")
    public void modifyPrivacy(@PathVariable("id") String id, @PathVariable("privacy") Privacy privacy) {
        interestDAO.modifyInterestPrivacy(id, privacy);
    }



}
