package com.boun.motive.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Comment implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2992342805205926008L;

	@Id
    private String id;

    @NotNull
    private String description;

    @NotNull
    private String userId;

    @NotNull
    private String contentId;

    public Comment()
    {

    }

    public Comment(String id, String description, String userId, String contentId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.contentId = contentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}
