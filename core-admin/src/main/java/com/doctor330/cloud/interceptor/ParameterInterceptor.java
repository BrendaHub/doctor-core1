package com.doctor330.cloud.interceptor;

import com.doctor330.cloud.common.ActionInvocation;
import com.doctor330.cloud.utils.RequestToBean;

public class ParameterInterceptor implements Interceptor {
	public void intercept(ActionInvocation invocation) {
		try{
			RequestToBean.populate(invocation.getRequest(), invocation.getAction());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		invocation.invoke();
	}
	
}
