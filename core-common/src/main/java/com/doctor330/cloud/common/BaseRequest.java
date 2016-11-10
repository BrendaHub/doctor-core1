package com.doctor330.cloud.common;

import java.util.Map;

/**
 *  请求接口。
 * 
 */
public interface BaseRequest<T extends BaseResponse> {

	/**
	 * 获取 的API名称。
	 * 
	 * @return API名称
	 */
    String getApiMethodName();

	/**
	 * 获取所有的Key-Value形式的文本请求参数集合。其中：
	 * <ul>
	 * <li>Key: 请求参数名</li>
	 * <li>Value: 请求参数值</li>
	 * </ul>
	 * 
	 * @return 文本请求参数集合
	 */
    Map<String, String> getTextParams();

	/**
	 * @return 指定或默认的时间戳
	 */
    Long getTimestamp();

	/**
	 * 设置时间戳，如果不设置,发送请求时将使用当时的时间。
	 * 
	 * @param timestamp 时间戳
	 */
    void setTimestamp(Long timestamp);
	

	Class<T> getResponseClass();

	void check() throws ApiRuleException;
}
