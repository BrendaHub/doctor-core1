package com.doctor330.cloud.common;

import com.doctor330.cloud.config.ActionMapping;

public abstract class Factory {
	
	public abstract ApiActionInterfaces buildAction(ActionMapping actionMapping);
	
	public abstract Object get(String beanName);
}	
