package com.boun.motive.repository;

import com.boun.motive.model.Annotation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnotationMongoRepository extends MongoRepository<Annotation, String> {

}
