package com.boun.motive.model;

import com.boun.motive.util.constant.Privacy;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Content implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4524964076993066786L;

	@Id
    private String id;

    @NotNull
    private String title;

    private List<String> tags;

    private String userId;

    @NotNull
    private String interestId;

    private int upVoteCount;

    private int downVoteCount;

    private Privacy contentPrivacy;

    @JsonIgnore
	protected Map<String, Object> nonMappedAttributes;

	@JsonAnyGetter
	public Map<String, Object> getNonMappedAttributes() {
		return nonMappedAttributes;
	}

	@JsonAnySetter
	public void setNonMappedAttributes(String key, Object value) {
		if (nonMappedAttributes == null) {
			nonMappedAttributes = new HashMap<String, Object>();
		}
		if (key != null) {
			if (value != null) {
				nonMappedAttributes.put(key, value);
			} else {
				nonMappedAttributes.remove(key);
			}
		}
	}
    
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
