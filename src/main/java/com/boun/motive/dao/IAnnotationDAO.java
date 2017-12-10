package com.boun.motive.dao;

import com.boun.motive.model.Annotation;

import java.util.List;

public interface IAnnotationDAO {
    Annotation createAnnotation(Annotation annotation);
    List<Annotation> getAnnotationsByContentId(String contentId);
    List<Annotation> getAnnotationsByUserId(String userId);
}
