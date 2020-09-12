package com.example.demo.model.annotation;
 
import static java.lang.annotation.ElementType.FIELD; 
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload; 
 
@Constraint(validatedBy = { UniqueUsernameValidator.class})
@Target({ FIELD})
@Retention(RUNTIME) 
public @interface UniqueData {


	String message() default "{message.unique.data}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
