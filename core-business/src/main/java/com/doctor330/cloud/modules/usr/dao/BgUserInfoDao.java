/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.dao;

import java.util.List;

import com.doctor330.cloud.common.persistence.CrudDao;
import com.doctor330.cloud.common.persistence.annotation.MyBatisDao;
import com.doctor330.cloud.modules.usr.entity.BgUserInfo;

/**
 * 用户信息表DAO接口
 * @author 郑源
 * @version 2016-11-05
 */
@MyBatisDao
public interface BgUserInfoDao extends CrudDao<BgUserInfo> {
	/**
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * @param entity
	 * @return
	 */
	public List<BgUserInfo> findRoleList(BgUserInfo entity);
	
}