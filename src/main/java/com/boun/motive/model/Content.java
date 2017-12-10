package com.boun.motive.model;

import com.boun.motive.util.constant.Privacy;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class Content implements Serializable {

    @Id
    private String id;

    @NotNull
    private String contentType;

    @NotNull
    private String title;

    @NotNull
    private String description;

    private List<String> tags;

    @NotNull
    private String userId;

    @NotNull
    private String interestId;

    private int upVoteCount;

    private int downVoteCount;

    private Privacy contentPrivacy;

    public Content()
    {

    }

    public Content(String id, String contentType, String title, String description, List<String> tags, String userId, String interestId, int upVoteCount, int downVoteCount, Privacy contentPrivacy) {
        this.id = id;
        this.contentType = contentType;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.userId = userId;
        this.interestId = interestId;
        this.upVoteCount = upVoteCount;
        this.downVoteCount = downVoteCount;
        this.contentPrivacy = contentPrivacy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInterestId() {
        return interestId;
    }

    public void setInterestId(String interestId) {
        this.interestId = interestId;
    }

    public int getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(int upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public Privacy getContentPrivacy() {
        return contentPrivacy;
    }

    public void setContentPrivacy(Privacy contentPrivacy) {
        this.contentPrivacy = contentPrivacy;
    }
}
