package com.boun.motive.service;

import java.util.List;

import com.boun.motive.model.Content;
import com.boun.motive.util.constant.Privacy;

public interface IContentService {
    Content createContent(Content content);
    List<Content> getAllContents();
    Content getContentById(String id);
    List<Content> getContentsByInterest(String interestId);
    Content comment(String id, String comment);
    Content tagContent(String id, String tag);
    Content removeTagFromContent(String id, String tag);
    Content modifyContentPrivacy(String id, Privacy privacy);
    Content upVoteContent(String id);
    Content downVoteContent(String id);
    void deleteContent(String id);
}
