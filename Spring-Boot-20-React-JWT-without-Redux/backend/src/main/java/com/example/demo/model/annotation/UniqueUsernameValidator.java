package com.example.demo.model.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueData, String> {

	@Autowired
	UserRepository repository; 
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		User user = repository.findByUsername(value);
		if(user != null) return false;
		return true;
	}
 
}
