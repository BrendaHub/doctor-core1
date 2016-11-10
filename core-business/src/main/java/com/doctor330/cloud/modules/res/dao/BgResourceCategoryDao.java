/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.res.dao;

import java.util.List;

import com.doctor330.cloud.common.persistence.CrudDao;
import com.doctor330.cloud.common.persistence.annotation.MyBatisDao;
import com.doctor330.cloud.modules.res.entity.BgResourceCategory;

/**
 * 行业管理的增删改查DAO接口
 * @author 武海升
 * @version 2016-11-05
 */
@MyBatisDao
public interface BgResourceCategoryDao extends CrudDao<BgResourceCategory> {
	
	Integer getIsOrder(String id);
	List<BgResourceCategory> findFatherList(BgResourceCategory bgResourceCategory);
	
}