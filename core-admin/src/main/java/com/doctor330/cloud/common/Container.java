package com.doctor330.cloud.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doctor330.cloud.config.ActionMapping;




public abstract class Container {
	
	public static Factory factory;
	
	public static ActionInvocation getActionInvoaction(
		ActionMapping actionMapping, HttpServletRequest request, HttpServletResponse response) {
		
		return new DefaultActionInvocation(request, response, actionMapping);
	}
	
	public static void main(String a[]) {
	}
}
