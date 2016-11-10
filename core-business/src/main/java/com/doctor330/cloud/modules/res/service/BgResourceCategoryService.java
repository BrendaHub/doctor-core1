/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.res.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doctor330.cloud.common.persistence.Page;
import com.doctor330.cloud.common.service.CrudService;
import com.doctor330.cloud.modules.res.entity.BgResourceCategory;
import com.doctor330.cloud.modules.res.dao.BgResourceCategoryDao;

/**
 * 行业管理的增删改查Service
 * @author 武海升
 * @version 2016-11-05
 */
@Service
@Transactional(readOnly = true)
public class BgResourceCategoryService extends CrudService<BgResourceCategoryDao, BgResourceCategory> {

	@Autowired
	private BgResourceCategoryDao bgResourceCategoryDao;
	
	public BgResourceCategory get(String id) {
		return super.get(id);
	}
	
	public List<BgResourceCategory> findList(BgResourceCategory bgResourceCategory) {
		return super.findList(bgResourceCategory);
	}
	
	public Page<BgResourceCategory> findPage(Page<BgResourceCategory> page, BgResourceCategory bgResourceCategory) {
		return super.findPage(page, bgResourceCategory);
	}
	
	@Transactional(readOnly = false)
	public void save(BgResourceCategory bgResourceCategory) {
		super.save(bgResourceCategory);
	}
	
	@Transactional(readOnly = false)
	public void delete(BgResourceCategory bgResourceCategory) {
		super.delete(bgResourceCategory);
	}
	
	public Integer getIsOrder(String id) {

		return bgResourceCategoryDao.getIsOrder(id);
	}
	
	public List<BgResourceCategory> findFatherList(BgResourceCategory bgResourceCategory) {
		return bgResourceCategoryDao.findFatherList(bgResourceCategory);
	}
	
}