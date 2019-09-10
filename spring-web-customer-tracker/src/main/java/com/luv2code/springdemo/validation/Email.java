package com.luv2code.springdemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Constraint(validatedBy=EmailConstraintValidator.class)
@Target({ ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
	// define the Attribute Email
	public String  value() default "@";
	// define the error message 
	public String message() default "must start with @";
	// define default group
	public Class<?>[] groups() default {};
	//define default payload
	public Class <? extends Payload>[] payload() default {};
}
