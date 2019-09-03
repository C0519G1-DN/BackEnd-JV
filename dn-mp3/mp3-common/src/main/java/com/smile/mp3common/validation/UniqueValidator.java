package com.smile.mp3common.validation;


import com.smile.mp3dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique,String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.countByUsernameOrEmail(value,value)<=0;
    }

    @Override
    public void initialize(Unique constraintAnnotation) {

    }
}
