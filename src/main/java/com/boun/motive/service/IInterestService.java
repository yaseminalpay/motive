package com.boun.motive.service;

import com.boun.motive.model.CustomProperty;
import com.boun.motive.model.Interest;
import com.boun.motive.util.constant.Privacy;

import java.util.List;

public interface IInterestService {
    Interest createInterest(Interest interest);
    List<Interest> getInterests();
    Interest getInterestByTitle(String title);
    List<Interest> getInterestsByUserId(String userId);
    List<Interest> getInterestByKeyword(String keyword);
    List<CustomProperty> getProperties(String id);
    Interest modifyInterestPrivacy(String id, Privacy privacy);
    void deleteInterest(String id);
}
