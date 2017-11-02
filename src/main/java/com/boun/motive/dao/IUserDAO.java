package com.boun.motive.dao;

import com.boun.motive.model.User;

public interface IUserDAO {
    public void createUser(User user);
    public void modifyUser(String id, User user);
    public User getUserById(String id);
    public User getUserByUsername(String username);
}
