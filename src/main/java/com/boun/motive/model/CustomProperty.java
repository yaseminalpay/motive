package com.boun.motive.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CustomProperty implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3627754159059163862L;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String description;

    private Object value;

    public CustomProperty() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
