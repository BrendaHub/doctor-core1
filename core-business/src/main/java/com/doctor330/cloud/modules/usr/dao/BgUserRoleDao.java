/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.dao;

import com.doctor330.cloud.common.persistence.CrudDao;
import com.doctor330.cloud.common.persistence.annotation.MyBatisDao;
import com.doctor330.cloud.modules.usr.entity.BgUserRole;

/**
 * 用户角色关系表DAO接口
 * @author 郑源
 * @version 2016-11-05
 */
@MyBatisDao
public interface BgUserRoleDao extends CrudDao<BgUserRole> {
	
}