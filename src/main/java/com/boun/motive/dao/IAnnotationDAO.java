package com.boun.motive.dao;

import com.boun.motive.model.Annotation;

import java.util.List;

public interface IAnnotationDAO {
    public void createAnnotation(Annotation annotation);
    public List<Annotation> getAnnotationsByContentId(String contentId);
    public List<Annotation> getAnnotationsByUserId(String userId);
}
