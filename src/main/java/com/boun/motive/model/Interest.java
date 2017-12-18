package com.boun.motive.model;

import com.boun.motive.util.constant.Privacy;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class Interest implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5351781471764480911L;

	@Id
    private String id;

    @NotNull
    private String title;

    private String description;

    private Privacy interestPrivacy;

    private String userId;
    
    @NotNull
	private List<CustomProperty> properties;
    
    public Interest()
    {

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

	public List<CustomProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<CustomProperty> properties) {
		this.properties = properties;
	}
}
