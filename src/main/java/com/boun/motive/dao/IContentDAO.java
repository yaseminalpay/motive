package com.boun.motive.dao;

import com.boun.motive.model.Content;
import com.boun.motive.util.constant.Privacy;

import java.util.List;

public interface IContentDAO {
    public void createContent(Content content);
    public Content getContentById(String id);
    public List<Content> getContentsByInterest(String interestId);
    public List<Content> getContentsByInterestAndUser(String interestId, String userId);
    public void tagContent(String id, String tag);
    public void removeTagFromContent(String id, String tag);
    public void modifyContentPrivacy(String id, Privacy privacy);
    public void upVoteContent(String id);
    public void downVoteContent(String id);
}
