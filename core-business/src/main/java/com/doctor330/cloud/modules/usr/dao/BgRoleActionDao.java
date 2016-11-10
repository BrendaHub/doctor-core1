/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.dao;

import com.doctor330.cloud.common.persistence.CrudDao;
import com.doctor330.cloud.common.persistence.annotation.MyBatisDao;
import com.doctor330.cloud.modules.usr.entity.BgRoleAction;

/**
 * 角色行为关系表DAO接口
 * @author 郑源
 * @version 2016-11-05
 */
@MyBatisDao
public interface BgRoleActionDao extends CrudDao<BgRoleAction> {
	
}