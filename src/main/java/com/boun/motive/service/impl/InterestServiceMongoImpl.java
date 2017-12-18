package com.boun.motive.service.impl;

import com.boun.motive.model.CustomProperty;
import com.boun.motive.model.Interest;
import com.boun.motive.repository.InterestMongoRepository;
import com.boun.motive.service.IInterestService;
import com.boun.motive.util.constant.Privacy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InterestServiceMongoImpl implements IInterestService {

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
    public Interest getInterest(String id) {
        return interestMongoRepository.findOne(id);
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
    public List<CustomProperty> getProperties(String id) {
        Interest interest = interestMongoRepository.findOne(id);
        List<CustomProperty> properties = interest.getProperties();
        return properties;
    }

    @Override
    public Interest modifyInterestPrivacy(String id, Privacy privacy) {
        Interest interest = interestMongoRepository.findOne(id);
        interest.setInterestPrivacy(privacy);
        interestMongoRepository.save(interest);
        return interest;
    }
    
    @Override
	public void deleteInterest(String id) {
    	interestMongoRepository.delete(id);
	}
}
