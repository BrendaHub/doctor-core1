package com.doctor330.cloud.interceptor;

import com.doctor330.cloud.common.ActionInvocation;

public interface Interceptor {
	
	void intercept(ActionInvocation invocation);
}
