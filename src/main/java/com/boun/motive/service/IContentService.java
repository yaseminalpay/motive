package com.boun.motive.service;

import com.boun.motive.model.Content;
import com.boun.motive.util.constant.Privacy;

import java.util.List;

public interface IContentService {
    Content createContent(Content content);
    Content getContentById(String id);
    List<Content> getContentsByInterest(String interestId);
    Content tagContent(String id, String tag);
    Content removeTagFromContent(String id, String tag);
    Content modifyContentPrivacy(String id, Privacy privacy);
    Content upVoteContent(String id);
    Content downVoteContent(String id);
    void deleteContent(String id);
}
