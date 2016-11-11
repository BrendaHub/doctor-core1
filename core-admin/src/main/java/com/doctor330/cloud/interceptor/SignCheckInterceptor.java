package com.doctor330.cloud.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.doctor330.cloud.common.ActionInvocation;




/**
 * 检查签名
 * 
 * @author Arron
 * 
 */
public class SignCheckInterceptor implements Interceptor {
	
	public static final String MULTIPART = "multipart/";
	public void intercept(ActionInvocation invocation) {
		
		try {
			HttpServletRequest request = invocation.getRequest();
			
			String requestMethord = request.getQueryString();
			if(checkRequestMethord(requestMethord)){
				if(request.getParameter("sign")==null){
					String clientToken =  request.getParameter("token");
					String bindId = request.getParameter("bindid");
					Boolean checkTokenResult = checkToken(clientToken,bindId);
					if(!checkTokenResult){
						throw new RuntimeException("请求超时，请重新启动应用！");
					}
				}
			}
			invocation.invoke();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("APP接口执行异常.....");
			throw new RuntimeException("系统繁忙，请重新启动应用！");
		}
	}
	private Boolean checkToken(String clientToken,String bindId){
		
		if(bindId == null || "".equals(bindId))
			return false;
		//String serverToken =  redisService.getRedisValueByKey(bindId);
		String serverToken = "";
		if(serverToken == null || clientToken==null)
			return false;
        return clientToken.equals(serverToken);
    }
	
	private boolean checkRequestMethord(String requestMethord) {
		if(requestMethord.contains("uploadTempPic"))
			return false;
		if(requestMethord.contains("uploadHeadPic"))
			return false;
		if(requestMethord.contains("uploadBusinessCard"))
			return false;
		if(requestMethord.contains("uploadErrorLogForAndroid1_1"))
			return false;
		if(requestMethord.contains("uploadCompanyBusinessLicense1_1"))
			return false;
        return !requestMethord.contains("uploadCompanyLogo1_1");

    }


	public Map<String, Object> getFormMap(HttpServletRequest request) {
		return null;
	}

}
