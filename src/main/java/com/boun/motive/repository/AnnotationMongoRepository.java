package com.boun.motive.repository;

import com.boun.motive.model.Annotation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationMongoRepository extends MongoRepository<Annotation, String> {

}
