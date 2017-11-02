package com.boun.motive.model;

import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

public class AnnotationBody {

    @NotNull
    private String type;

    @NotNull
    private String value;

    private String format;

    private String language;

    private String creator;

    private DateTime created;

    public AnnotationBody()
    {

    }

    public AnnotationBody(String type, String value, String format, String language, String creator, DateTime created) {
        this.type = type;
        this.value = value;
        this.format = format;
        this.language = language;
        this.creator = creator;
        this.created = created;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }
}
