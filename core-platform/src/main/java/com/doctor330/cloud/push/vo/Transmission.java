package com.doctor330.cloud.push.vo;

import java.io.Serializable;

/**
 * @author  郑源
 * @date 创建时间：2016年3月2日 上午9:54:49 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return 
 */
public class Transmission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 长度：2048中/英字符
	 * 必填：是
	 * 默认值：
	 * 说明:透传内容，不支持转义字符
	 */
	private String transmissionContent;
	
	/**
	 * 长度：4byte
	 * 必填：是
	 * 默认值：
	 * 说明:收到消息是否立即启动应用，1为立即启动，2则广播等待客户端自启动
	 */
	private Integer transmissionType;

	public String getTransmissionContent() {
		return transmissionContent;
	}

	public void setTransmissionContent(String transmissionContent) {
		this.transmissionContent = transmissionContent;
	}

	public Integer getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(Integer transmissionType) {
		this.transmissionType = transmissionType;
	}
	
	
	
}
