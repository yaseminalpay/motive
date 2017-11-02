package com.boun.motive.util.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = {AnnotationValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target( {TYPE} )
public @interface AnnotationValid {
    String message() default "Invalid annotation: Cannot validate JSON-LD";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}