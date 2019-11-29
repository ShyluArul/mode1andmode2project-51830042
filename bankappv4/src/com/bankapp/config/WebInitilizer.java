package com.bankapp.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//rootcontext
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{ModelConfig.class,SecurityConfig.class};
	}

	//for webappcontext
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext wac) {
		DispatcherServlet ds = new DispatcherServlet(wac);
		ds.setThrowExceptionIfNoHandlerFound(true);
		return ds;
	}
	

	
	
}





