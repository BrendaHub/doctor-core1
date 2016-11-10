package com.doctor330.cloud.server.message;

import java.io.Serializable;

/**
 * @author 郑源
 * @date 创建时间：2016年2月25日 下午7:35:10
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public interface IMessageService extends Serializable {
	
	

	
	/**
	 * 向单个用户推送透传消息,所有单个用户的推送建议用这个接口
	 * @param userId 用户ID
	 * @param transmissionContent 推送的消息内容，格式为JSON串
	 * @param transmissionType 收到消息是否立即启动应用，1为立即启动，2则广播等待客户端自启动
	 * @param offlineExpireTime 离线时间，单位为毫秒
	 * @return Boolean
	 */
	public Boolean pushMessageToSingleUser(Integer userId , String transmissionContent ,Integer transmissionType,Integer offlineExpireTime);
	
	
	
	
	
	
	

}
