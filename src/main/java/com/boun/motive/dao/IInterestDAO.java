package com.boun.motive.dao;

import com.boun.motive.model.Interest;
import com.boun.motive.util.constant.Privacy;

import java.util.List;

public interface IInterestDAO {
    public void createInterest(Interest interest);
    public List<Interest> getInterests();
    public List<Interest> getInterestsByUserId(String userId);
    public List<Interest> getInterestByKeyword(String keyword);
    public void modifyInterestPrivacy(String id, Privacy privacy);
}
