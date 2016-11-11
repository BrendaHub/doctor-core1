package com.doctor330.cloud.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ApiActionInterfaces {
	
	String execute() throws Exception;
	
	void setRequest(HttpServletRequest request);
	
	void setResponse(HttpServletResponse response);
	
	String getResponseName();
	
	String getFormat();
	
	String getFields();
	
	void setMsg(String msg);
	
	String getType();
	
	boolean isIssuccessful();
	
	void setIssuccessful(boolean issuccessful) ;
	
	Integer getStatuscode();
	
	void setStatuscode(Integer code);
	
	String getDescription();
	
	void setDescription(String description);
	
	String getUserId();
	
	void setUserId(String userId) ;
}
