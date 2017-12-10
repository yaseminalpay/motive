package com.boun.motive.model;

import com.boun.motive.util.constant.Privacy;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Interest implements Serializable {

    @Id
    private String id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Privacy interestPrivacy;

    @NotNull
    private String userId;

    public Interest()
    {

    }

    public Interest(String id, String title, String description, Privacy interestPrivacy, String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.interestPrivacy = interestPrivacy;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Privacy getInterestPrivacy() {
        return interestPrivacy;
    }

    public void setInterestPrivacy(Privacy interestPrivacy) {
        this.interestPrivacy = interestPrivacy;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
