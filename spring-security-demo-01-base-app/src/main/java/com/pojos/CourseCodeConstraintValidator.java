package com.pojos;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
	implements ConstraintValidator<OneTimeCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(OneTimeCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, 
						ConstraintValidatorContext theConstraintValidatorContext) {

		boolean rs = false;
		String rex1="^[a-zA-Z0-9]{5}";
		String rex2="^[a-zA-Z0-9]{7}";
		if (theCode == null||theCode.equals("")||theCode.trim().equals("")) {
		rs=true;
	    }else{
	    	if(theCode.trim().matches(rex1)||theCode.trim().matches(rex2)){
	    		rs=true;
	    	}else{
	    		rs=false;
	    	}
	}
		return rs;
}
		

}








