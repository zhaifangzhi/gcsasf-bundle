package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Dispatcher extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<DemoAppConfig>[] c=new Class[]{DemoAppConfig.class};
		return c;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

}
