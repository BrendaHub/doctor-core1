package com.doctor330.cloud.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface ActionInvocation {
	
	ApiActionInterfaces getAction();
	HttpServletRequest getRequest();
	HttpServletResponse getResponse();
	
	void invoke();
	
}
