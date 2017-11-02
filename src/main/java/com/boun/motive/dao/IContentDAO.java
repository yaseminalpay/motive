package com.boun.motive.dao;

import com.boun.motive.model.Content;
import com.boun.motive.util.constant.Privacy;

import java.util.List;

public interface IContentDAO {
    Content createContent(Content content);
    Content getContentById(String id);
    List<Content> getContentsByInterestAndUser(String interestId, String userId);
    Content tagContent(String id, String tag);
    Content removeTagFromContent(String id, String tag);
    Content modifyContentPrivacy(String id, Privacy privacy);
    Content upVoteContent(String id);
    Content downVoteContent(String id);
}
