package com.boun.motive.service.impl;

import com.boun.motive.model.User;
import com.boun.motive.repository.UserMongoRepository;
import com.boun.motive.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceMongoImpl implements IUserService {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Override
    public User createUser(User user) {
        userMongoRepository.save(user);
        return user;
    }

    @Override
    public User modifyUser(String id, User user) {
        userMongoRepository.save(user);
        return user;

    }

    @Override
    public User getUserById(String id) {
        return userMongoRepository.findOne(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMongoRepository.findUserByUsername(username);
    }
}
