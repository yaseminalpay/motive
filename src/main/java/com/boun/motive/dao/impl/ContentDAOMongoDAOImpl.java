package com.boun.motive.dao.impl;

import com.boun.motive.dao.IContentDAO;
import com.boun.motive.model.Content;
import com.boun.motive.repository.ContentMongoRepository;
import com.boun.motive.util.constant.Privacy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ContentDAOMongoDAOImpl implements IContentDAO {

    @Autowired
    ContentMongoRepository contentMongoRepository;

    @Override
    public void createContent(Content content) {
        contentMongoRepository.save(content);

    }

    @Override
    public Content getContentById(String id) {
        return contentMongoRepository.findOne(id);
    }

    @Override
    public List<Content> getContentsByInterest(String interestId) {
        return contentMongoRepository.findByInterestId(interestId);
    }

    @Override
    public List<Content> getContentsByInterestAndUser(String interestId, String userId) {
        return contentMongoRepository.findByInterestIdAndUserId(interestId, userId);
    }

    @Override
    public void tagContent(String id, String tag) {
        Content content = contentMongoRepository.findOne(id);
        content.getTags().add(tag);
        contentMongoRepository.save(content);

    }

    @Override
    public void removeTagFromContent(String id, String tag) {
        Content content = contentMongoRepository.findOne(id);
        List<String> tags = content.getTags();
        if (!tags.isEmpty() && tags.contains(tag))
        {
            content.getTags().remove(tag);
        }
        contentMongoRepository.save(content);
    }

    @Override
    public void modifyContentPrivacy(String id, Privacy privacy) {
        Content content = contentMongoRepository.findOne(id);
        content.setContentPrivacy(privacy);
        contentMongoRepository.save(content);
    }

    @Override
    public void upVoteContent(String id) {
        Content content = contentMongoRepository.findOne(id);
        content.setUpVoteCount(content.getUpVoteCount() + 1);
        contentMongoRepository.save(content);

    }

    @Override
    public void downVoteContent(String id) {
        Content content = contentMongoRepository.findOne(id);
        content.setDownVoteCount(content.getDownVoteCount() + 1);
        contentMongoRepository.save(content);

    }
}
