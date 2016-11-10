package com.doctor330.cloud.common;

import java.io.Serializable;

public class Doctor330JsonObject implements Serializable{

	private static final long serialVersionUID = -3962260356171917310L;
	
	private String desc = "";
	private Integer statusCode = 0;
	private Boolean isSuccess = true;
	private Integer userId = 0;
	private Object data = new Object();
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
