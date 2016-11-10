/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.doctor330.cloud.common.persistence.DataEntity;

/**
 * 用户角色关系表Entity
 * @author 郑源
 * @version 2016-11-05
 */
public class BgUserRole extends DataEntity<BgUserRole> {
	
	private static final long serialVersionUID = 1L;
	private Integer userid;		// userid
	private String roleid;		// roleid
	
	public BgUserRole() {
		super();
	}

	public BgUserRole(String id){
		super(id);
	}

	@NotNull(message="userid不能为空")
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	@Length(min=1, max=64, message="roleid长度必须介于 1 和 64 之间")
	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
}