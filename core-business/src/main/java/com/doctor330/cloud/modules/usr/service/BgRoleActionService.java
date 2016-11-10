/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doctor330.cloud.common.persistence.Page;
import com.doctor330.cloud.common.service.CrudService;
import com.doctor330.cloud.modules.usr.entity.BgRoleAction;
import com.doctor330.cloud.modules.usr.dao.BgRoleActionDao;

/**
 * 角色行为关系表Service
 * @author 郑源
 * @version 2016-11-05
 */
@Service
@Transactional(readOnly = true)
public class BgRoleActionService extends CrudService<BgRoleActionDao, BgRoleAction> {

	public BgRoleAction get(String id) {
		return super.get(id);
	}
	
	public List<BgRoleAction> findList(BgRoleAction bgRoleAction) {
		return super.findList(bgRoleAction);
	}
	
	public Page<BgRoleAction> findPage(Page<BgRoleAction> page, BgRoleAction bgRoleAction) {
		return super.findPage(page, bgRoleAction);
	}
	
	@Transactional(readOnly = false)
	public void save(BgRoleAction bgRoleAction) {
		super.save(bgRoleAction);
	}
	
	@Transactional(readOnly = false)
	public void delete(BgRoleAction bgRoleAction) {
		super.delete(bgRoleAction);
	}
	
}