package com.boun.motive.controller;

import com.boun.motive.data.UserRepository;
import com.boun.motive.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/users/")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        userRepository.insert(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public User getByUsername(@PathVariable("username") String username) {
        return userRepository.findUserByUsername(username);
    }

}
