/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.push.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doctor330.cloud.common.persistence.Page;
import com.doctor330.cloud.common.service.CrudService;
import com.doctor330.cloud.modules.push.entity.BgUserPush;
import com.doctor330.cloud.modules.push.dao.BgUserPushDao;

/**
 * 关于消息推送的用户信息记录Service
 * @author 郑源
 * @version 2016-11-02
 */
@Service
@Transactional(readOnly = true)
public class BgUserPushService extends CrudService<BgUserPushDao, BgUserPush> {

	public BgUserPush get(String id) {
		return super.get(id);
	}
	
	public List<BgUserPush> findList(BgUserPush bgUserPush) {
		return super.findList(bgUserPush);
	}
	
	public Page<BgUserPush> findPage(Page<BgUserPush> page, BgUserPush bgUserPush) {
		return super.findPage(page, bgUserPush);
	}
	
	@Transactional(readOnly = false)
	public void save(BgUserPush bgUserPush) {
		super.save(bgUserPush);
	}
	
	@Transactional(readOnly = false)
	public void delete(BgUserPush bgUserPush) {
		super.delete(bgUserPush);
	}
	
}