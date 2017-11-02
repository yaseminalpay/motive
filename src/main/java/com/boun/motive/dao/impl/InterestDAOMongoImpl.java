package com.boun.motive.dao.impl;

import com.boun.motive.dao.IInterestDAO;
import com.boun.motive.model.Interest;
import com.boun.motive.repository.InterestMongoRepository;
import com.boun.motive.util.constant.Privacy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InterestDAOMongoImpl implements IInterestDAO {

    @Autowired
    InterestMongoRepository interestMongoRepository;

    @Override
    public void createInterest(Interest interest) {
        interestMongoRepository.save(interest);
    }

    @Override
    public List<Interest> getInterests() {
        return interestMongoRepository.findAll();
    }

    @Override
    public List<Interest> getInterestsByUserId(String userId) {

        return interestMongoRepository.findByUserId(userId);

    }

    @Override
    public List<Interest> getInterestByKeyword(String keyword) {
        return interestMongoRepository.findByTitleContains(keyword);
    }

    @Override
    public void modifyInterestPrivacy(String id, Privacy privacy) {
        Interest interest = interestMongoRepository.findOne(id);
        interest.setInterestPrivacy(privacy);
        interestMongoRepository.save(interest);
    }
}
