package com.boun.motive.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Comment implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2992342805205926008L;

    @NotNull
    private String description;

    @NotNull
    private String userId;

    public Comment()
    {

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

}
