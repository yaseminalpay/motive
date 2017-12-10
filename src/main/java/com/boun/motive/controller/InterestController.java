package com.boun.motive.controller;

import com.boun.motive.model.Interest;
import com.boun.motive.service.IInterestService;
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
    IInterestService interestService;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Interest> create(@RequestBody @Valid Interest interest) {
        interestService.createInterest(interest);
        return new ResponseEntity<>(interest, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Interest>> get() {
        return new ResponseEntity<>(interestService.getInterests(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public ResponseEntity<List<Interest>> get(@RequestParam("userId") String userId ) {
        return new ResponseEntity<>(interestService.getInterestsByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/q")
    public ResponseEntity<List<Interest>> search(@RequestParam String keyword) {
        return new ResponseEntity<>(interestService.getInterestByKeyword(keyword), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/privacy/{privacy}")
    public ResponseEntity<Interest> modifyPrivacy(@PathVariable("id") String id, @PathVariable("privacy") Privacy privacy) {
        return new ResponseEntity<>(interestService.modifyInterestPrivacy(id, privacy), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
    	interestService.deleteInterest(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
