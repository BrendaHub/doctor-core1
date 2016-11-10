/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doctor330.cloud.common.persistence.Page;
import com.doctor330.cloud.common.service.CrudService;
import com.doctor330.cloud.modules.usr.entity.BgUserInfo;
import com.doctor330.cloud.modules.usr.dao.BgUserInfoDao;

/**
 * 用户信息表Service
 * @author 郑源
 * @version 2016-11-05
 */
@Service
@Transactional(readOnly = true)
public class BgUserInfoService extends CrudService<BgUserInfoDao, BgUserInfo> {

	public BgUserInfo get(String id) {
		return super.get(id);
	}
	
	public List<BgUserInfo> findList(BgUserInfo bgUserInfo) {
		return super.findList(bgUserInfo);
	}
	
	public Page<BgUserInfo> findPage(Page<BgUserInfo> page, BgUserInfo bgUserInfo) {
		return super.findPage(page, bgUserInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(BgUserInfo bgUserInfo) {
		super.save(bgUserInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(BgUserInfo bgUserInfo) {
		super.delete(bgUserInfo);
	}
	
}