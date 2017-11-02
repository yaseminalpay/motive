package com.boun.motive.dao;

import com.boun.motive.model.User;

public interface IUserDAO {
    User createUser(User user);
    User modifyUser(String id, User user);
    User getUserById(String id);
    User getUserByUsername(String username);
}
