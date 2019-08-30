package com.smile.mp3common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueValidator.class)
@Retention(RUNTIME)
public @interface Unique {
    String message() default "Username is already exit";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
