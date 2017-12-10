package com.boun.motive.service.impl;

import com.boun.motive.model.Content;
import com.boun.motive.repository.ContentMongoRepository;
import com.boun.motive.service.IContentService;
import com.boun.motive.util.constant.Privacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ContentServiceMongoImpl implements IContentService {

    @Autowired
    ContentMongoRepository contentMongoRepository;

    @Override
    public Content createContent(Content content) {
        contentMongoRepository.save(content);
        return content;

    }

    @Override
    public Content getContentById(String id) {
        return contentMongoRepository.findOne(id);
    }


    @Override
    public List<Content> getContentsByInterestAndUser(String interestId, String userId) {
        List<Content> contents;

        if(!StringUtils.isEmpty(userId)) {
            contents = contentMongoRepository.findByInterestIdAndUserId(interestId, userId);
        }
        else {
            contents = contentMongoRepository.findByInterestId(interestId);
        }

        return contents;
    }

    @Override
    public Content tagContent(String id, String tag) {
        Content content = contentMongoRepository.findOne(id);
        List<String> tags = content.getTags();
        if(!tags.isEmpty() && tags.contains(tag))
        {
            return content;
        }
        else{
            tags.add(tag);
            contentMongoRepository.save(content);
        }
        return content;

    }

    @Override
    public Content removeTagFromContent(String id, String tag) {
        Content content = contentMongoRepository.findOne(id);
        List<String> tags = content.getTags();
        if (!tags.isEmpty() && tags.contains(tag))
        {
            content.getTags().remove(tag);
        }
        contentMongoRepository.save(content);
        return content;
    }

    @Override
    public Content modifyContentPrivacy(String id, Privacy privacy) {
        Content content = contentMongoRepository.findOne(id);
        content.setContentPrivacy(privacy);
        contentMongoRepository.save(content);
        return content;
    }

    @Override
    public Content upVoteContent(String id) {
        Content content = contentMongoRepository.findOne(id);
        content.setUpVoteCount(content.getUpVoteCount() + 1);
        contentMongoRepository.save(content);
        return content;

    }

    @Override
    public Content downVoteContent(String id) {
        Content content = contentMongoRepository.findOne(id);
        content.setDownVoteCount(content.getDownVoteCount() + 1);
        contentMongoRepository.save(content);
        return content;

    }
}
