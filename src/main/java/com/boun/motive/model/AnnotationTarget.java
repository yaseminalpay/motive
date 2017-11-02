package com.boun.motive.model;

import javax.validation.constraints.NotNull;

public class AnnotationTarget {

    @NotNull
    private String id;

    @NotNull
    private String type;

    @NotNull
    private String format;

    public AnnotationTarget()
    {

    }

    public AnnotationTarget(String id, String type, String format) {
        this.id = id;
        this.type = type;
        this.format = format;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
