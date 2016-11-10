/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.push.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.doctor330.cloud.common.persistence.DataEntity;

/**
 * 关于消息推送的用户信息记录Entity
 * @author 郑源
 * @version 2016-11-02
 */
public class BgUserPush extends DataEntity<BgUserPush> {
	
	private static final long serialVersionUID = 1L;
	private String userid;		// userid
	private String clientid;		// clientid
	private Date addtime;		// addtime
	private String ostype;		// ostype
	
	public BgUserPush() {
		super();
	}

	public BgUserPush(String id){
		super(id);
	}

	@Length(min=0, max=11, message="userid长度必须介于 0 和 11 之间")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=255, message="clientid长度必须介于 0 和 255 之间")
	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	@Length(min=0, max=255, message="ostype长度必须介于 0 和 255 之间")
	public String getOstype() {
		return ostype;
	}

	public void setOstype(String ostype) {
		this.ostype = ostype;
	}
	
}