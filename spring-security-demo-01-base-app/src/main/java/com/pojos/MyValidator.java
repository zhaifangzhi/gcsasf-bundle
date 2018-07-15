package com.pojos;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidator 
	implements ConstraintValidator<ForAppID, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(ForAppID theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, 
						ConstraintValidatorContext theConstraintValidatorContext) {

		boolean rs = false;
		String rex="^[0-9]*[1-9][0-9]*$";
		if (theCode == null||theCode.equals("")
				||theCode.trim().equals("")) {
		rs=true;
	    }else{
	    	if((theCode.trim().replace(" ", "").matches(rex))
	    			&&(theCode.trim().length()>1)
	    			&&(theCode.trim().length()<120)){
	    		rs=true;
	    	}else{
	    		rs=false;
	    	}
	}
		return rs;
}
		

}








