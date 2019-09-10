package com.luv2code.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraintValidator 
		implements ConstraintValidator<Email, String>{

	private String coursrPrefix;
	
	@Override
	public void initialize(Email theCourseCode) {
		coursrPrefix=theCourseCode.value();	
		
	}
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result;
		
		if (theCode!=null) {
			
			result=theCode.startsWith(coursrPrefix);
		}else {
		result=true;
	}
		return result;
	}
}


