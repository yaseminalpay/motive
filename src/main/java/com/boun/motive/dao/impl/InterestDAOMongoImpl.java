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
    public Interest createInterest(Interest interest) {
        Interest existingInterest = getInterestByTitle(interest.getTitle());
        if(existingInterest != null)
        {
            //TODO exception
            return interest;
        }
        interestMongoRepository.save(interest);
        return interest;
    }

    @Override
    public List<Interest> getInterests() {
        return interestMongoRepository.findAll();
    }

    @Override
    public Interest getInterestByTitle(String title) {
        return interestMongoRepository.findByTitle(title);
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
    public Interest modifyInterestPrivacy(String id, Privacy privacy) {
        Interest interest = interestMongoRepository.findOne(id);
        interest.setInterestPrivacy(privacy);
        interestMongoRepository.save(interest);
        return interest;
    }
}
