/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.entity;

import org.hibernate.validator.constraints.Length;

import com.doctor330.cloud.common.persistence.DataEntity;

/**
 * 角色行为关系表Entity
 * @author 郑源
 * @version 2016-11-05
 */
public class BgRoleAction extends DataEntity<BgRoleAction> {
	
	private static final long serialVersionUID = 1L;
	private String roleid;		// roleid
	private String actionid;		// actionid
	
	public BgRoleAction() {
		super();
	}

	public BgRoleAction(String id){
		super(id);
	}

	@Length(min=1, max=64, message="roleid长度必须介于 1 和 64 之间")
	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	@Length(min=1, max=64, message="actionid长度必须介于 1 和 64 之间")
	public String getActionid() {
		return actionid;
	}

	public void setActionid(String actionid) {
		this.actionid = actionid;
	}
	
}