package com.boun.motive.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class CustomProperty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3627754159059163862L;

	@Id
	private String id;

	@NotNull
	private String name;

	@NotNull
	private String type;
	
	public CustomProperty() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CustomProperty [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
