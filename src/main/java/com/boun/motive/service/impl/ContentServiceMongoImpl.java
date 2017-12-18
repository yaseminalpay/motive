package com.boun.motive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.boun.motive.model.Content;
import com.boun.motive.repository.ContentMongoRepository;
import com.boun.motive.service.IContentService;
import com.boun.motive.util.constant.Privacy;

public class ContentServiceMongoImpl implements IContentService {

	@Autowired
	ContentMongoRepository contentMongoRepository;

	@Override
	public Content createContent(Content content) {
		contentMongoRepository.save(content);
		return content;
	}
	
	@Override
	public List<Content> getAllContents() {
		List<Content> contents = contentMongoRepository.findAll();
		return contents;
	}

	@Override
	public Content getContentById(String id) {
		return contentMongoRepository.findOne(id);
	}

	@Override
	public List<Content> getContentsByInterest(String interestId) {
		List<Content> contents = contentMongoRepository.findByInterestId(interestId);
		return contents;
	}
	
	@Override
	public Content comment(String id, String comment) {
		Content content = contentMongoRepository.findOne(id);
		List<String> comments = content.getComments();
		if (comments != null && comments.contains(comment)) {
			return content;
		} else {
			if(comments == null) {
				comments = new ArrayList<>();
			}
			comments.add(comment);
			content.setComments(comments);
			contentMongoRepository.save(content);
		}
		return content;
	}

	@Override
	public Content tagContent(String id, String tag) {
		Content content = contentMongoRepository.findOne(id);
		List<String> tags = content.getTags();
		if (tags != null && tags.contains(tag)) {
			return content;
		} else {
			if(tags == null) {
				tags = new ArrayList<>();
			}
			tags.add(tag);
			content.setTags(tags);
			contentMongoRepository.save(content);
		}
		return content;

	}

	@Override
	public Content removeTagFromContent(String id, String tag) {
		Content content = contentMongoRepository.findOne(id);
		List<String> tags = content.getTags();
		if (!tags.isEmpty() && tags.contains(tag)) {
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

	@Override
	public void deleteContent(String id) {
		contentMongoRepository.delete(id);
	}

}
