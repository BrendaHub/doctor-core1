package com.doctor330.cloud.common.base;

import com.alibaba.fastjson.JSON;

public class BaseService {

	/**
	 * 封装返回的JSON数据
	 * 
	 * @param desc
	 *            状态描述
	 * @param statusCode
	 *            状态码
	 * @param isSuccess
	 *            是否成功
	 * @param userId
	 *            用户ID
	 * @param data
	 *            数据
	 * @return
	 */
	public String getdoctor330JsonObject(String desc, Integer statusCode, Boolean isSuccess, Integer userId,
			Object data) {

		return "";
	}
	
	/**
	 * 获取JSON字符串
	 * @param data
	 * @return
	 */
	public String getJsonString(Object data){
		
		String jsonString = JSON.toJSONString(data);
		return jsonString;
	}
}
