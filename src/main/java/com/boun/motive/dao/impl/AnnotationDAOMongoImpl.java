package com.boun.motive.dao.impl;

import com.boun.motive.dao.IAnnotationDAO;
import com.boun.motive.model.Annotation;
import com.boun.motive.repository.AnnotationMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnnotationDAOMongoImpl implements IAnnotationDAO{

    @Autowired
    AnnotationMongoRepository annotationMongoRepository;

    @Override
    public Annotation createAnnotation(Annotation annotation) {
        annotationMongoRepository.save(annotation);
        return annotation;
    }

    @Override
    public List<Annotation> getAnnotationsByContentId(String contentId) {
        return null;
    }

    @Override
    public List<Annotation> getAnnotationsByUserId(String userId) {
        return null;
    }
}
