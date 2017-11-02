package com.boun.motive.util.validator;

import com.boun.motive.model.Annotation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jsonldjava.core.JsonLdError;
import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnnotationValidator implements ConstraintValidator<AnnotationValid, Annotation> {

    @Override
    public void initialize(AnnotationValid annotationValid) {

    }

    @Override
    public boolean isValid(Annotation annotationValue, ConstraintValidatorContext context) {
        try {
            validate(annotationValue);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String validate(Annotation annotation) throws IOException, JsonLdError {

        // Create new object mapper instance
        ObjectMapper mp = new ObjectMapper();

        // Create jsonObject from given object
        Object jsonObject = mp.convertValue(annotation, LinkedHashMap.class);

        // Create a context JSON map containing prefixes and definitions
        Map context = new HashMap();
        // Customise context...

        // Create an instance of JsonLdOptions with the standard JSON-LD options
        JsonLdOptions options = new JsonLdOptions();
        // Customise options...

        // Call whichever JSON-LD function you want! (e.g. compact)
        Object compact = JsonLdProcessor.compact(jsonObject, context, options);

        return JsonUtils.toPrettyString(compact);
    }
}
