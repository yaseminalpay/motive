package com.boun.motive.controller;

import com.boun.motive.dao.IUserDAO;
import com.boun.motive.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users/")
public class UserController {

    @Autowired
    private IUserDAO userDAO;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        userDAO.createUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public User getByUsername(@PathVariable("username") String username) {
        return userDAO.getUserByUsername(username);
    }

}
