/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/Doctor330/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.oa.dao;

import com.doctor330.cloud.common.persistence.CrudDao;
import com.doctor330.cloud.common.persistence.annotation.MyBatisDao;
import com.doctor330.cloud.modules.oa.entity.TestAudit;

/**
 * 审批DAO接口
 * @author Doctor330
 * @version 2014-05-16
 */
@MyBatisDao
public interface TestAuditDao extends CrudDao<TestAudit> {

	public TestAudit getByProcInsId(String procInsId);
	
	public int updateInsId(TestAudit testAudit);
	
	public int updateHrText(TestAudit testAudit);
	
	public int updateLeadText(TestAudit testAudit);
	
	public int updateMainLeadText(TestAudit testAudit);
	
}
