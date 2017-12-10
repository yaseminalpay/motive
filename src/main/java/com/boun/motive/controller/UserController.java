package com.boun.motive.controller;

import com.boun.motive.model.User;
import com.boun.motive.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users/")
public class UserController {

    @Autowired
    private IUserService userDAO;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        userDAO.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(userDAO.getUserByUsername(username), HttpStatus.OK);
    }

}
