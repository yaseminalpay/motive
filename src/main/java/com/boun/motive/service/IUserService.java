package com.boun.motive.service;

import com.boun.motive.model.User;

public interface IUserService {
    User createUser(User user);
    User modifyUser(String id, User user);
    User getUserById(String id);
    User getUserByUsername(String username);
}
