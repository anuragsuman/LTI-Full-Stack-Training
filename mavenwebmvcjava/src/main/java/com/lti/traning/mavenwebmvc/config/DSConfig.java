package com.lti.traning.mavenwebmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Auto registers DS
public class DSConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	// array of spring config class
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	// array of spring config class for servlet support
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletSupportConfig.class};
	}

	// required to return URL Mapping
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
