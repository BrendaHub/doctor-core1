/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/Doctor330/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.sys.dao;

import com.doctor330.cloud.common.persistence.CrudDao;
import com.doctor330.cloud.common.persistence.annotation.MyBatisDao;
import com.doctor330.cloud.modules.sys.entity.Log;

/**
 * 日志DAO接口
 * @author Doctor330
 * @version 2014-05-16
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

}
