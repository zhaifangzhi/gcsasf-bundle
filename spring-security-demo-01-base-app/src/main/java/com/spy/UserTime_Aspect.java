package com.spy;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserTime_Aspect {
	
	@Pointcut("execution(public void model.ServiceImp.save(*))")
	private void applysomeadvice(){
	}

}
