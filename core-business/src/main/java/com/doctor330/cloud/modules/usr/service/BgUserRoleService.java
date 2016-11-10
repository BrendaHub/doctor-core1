/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doctor330.cloud.common.persistence.Page;
import com.doctor330.cloud.common.service.CrudService;
import com.doctor330.cloud.modules.usr.entity.BgUserRole;
import com.doctor330.cloud.modules.usr.dao.BgUserRoleDao;

/**
 * 用户角色关系表Service
 * @author 郑源
 * @version 2016-11-05
 */
@Service
@Transactional(readOnly = true)
public class BgUserRoleService extends CrudService<BgUserRoleDao, BgUserRole> {

	public BgUserRole get(String id) {
		return super.get(id);
	}
	
	public List<BgUserRole> findList(BgUserRole bgUserRole) {
		return super.findList(bgUserRole);
	}
	
	public Page<BgUserRole> findPage(Page<BgUserRole> page, BgUserRole bgUserRole) {
		return super.findPage(page, bgUserRole);
	}
	
	@Transactional(readOnly = false)
	public void save(BgUserRole bgUserRole) {
		super.save(bgUserRole);
	}
	
	@Transactional(readOnly = false)
	public void delete(BgUserRole bgUserRole) {
		super.delete(bgUserRole);
	}
	
}