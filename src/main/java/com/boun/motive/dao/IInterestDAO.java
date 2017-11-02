package com.boun.motive.dao;

import com.boun.motive.model.Interest;
import com.boun.motive.util.constant.Privacy;

import java.util.List;

public interface IInterestDAO {
    Interest createInterest(Interest interest);
    List<Interest> getInterests();
    Interest getInterestByTitle(String title);
    List<Interest> getInterestsByUserId(String userId);
    List<Interest> getInterestByKeyword(String keyword);
    Interest modifyInterestPrivacy(String id, Privacy privacy);
}
