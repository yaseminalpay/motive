package com.boun.motive.dao.impl;

import com.boun.motive.dao.IUserDAO;
import com.boun.motive.model.User;
import com.boun.motive.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOMongoImpl implements IUserDAO {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Override
    public void createUser(User user) {
        userMongoRepository.save(user);
    }

    @Override
    public void modifyUser(String id, User user) {
        userMongoRepository.save(user);

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
