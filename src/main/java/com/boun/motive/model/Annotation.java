package com.boun.motive.model;

import com.boun.motive.util.validator.AnnotationValid;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AnnotationValid
public class Annotation implements Serializable {

    @JsonProperty("@context")
    @NotNull
    private String context;

    @Id
    private String id;

    @NotNull
    private String type;

    @Indexed
    @NotNull
    private String creator;

    @NotNull
    private DateTime created;

    private DateTime modified;

    @NotNull
    private AnnotationBody body;

    @NotNull
    @Indexed
    private AnnotationTarget target;

    public Annotation()
    {

    }

    public Annotation(String context, String id, String type, String creator, DateTime created, DateTime modified, AnnotationBody body, AnnotationTarget target) {
        this.context = context;
        this.id = id;
        this.type = type;
        this.creator = creator;
        this.created = created;
        this.modified = modified;
        this.body = body;
        this.target = target;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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

    public DateTime getModified() {
        return modified;
    }

    public void setModified(DateTime modified) {
        this.modified = modified;
    }

    public AnnotationBody getBody() {
        return body;
    }

    public void setBody(AnnotationBody body) {
        this.body = body;
    }

    public AnnotationTarget getTarget() {
        return target;
    }

    public void setTarget(AnnotationTarget target) {
        this.target = target;
    }
}
