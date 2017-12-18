package com.boun.motive.model;

import com.boun.motive.util.constant.Privacy;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class Content implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4524964076993066786L;

	@Id
    private String id;

    @NotNull
    private String title;

    private String imgPath;

    private String description;
    
    private List<String> comments;

    private List<String> tags;
    
    private String userId;

    @NotNull
    private String interestId;

    private int upVoteCount;

    private int downVoteCount;

    private Privacy contentPrivacy;

	List<CustomProperty> customProperties;

	public Content(){
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

    public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
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

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

    public List<CustomProperty> getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(List<CustomProperty> customProperties) {
        this.customProperties = customProperties;
    }
}
