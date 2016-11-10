/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.push.dao;

import com.doctor330.cloud.common.persistence.CrudDao;
import com.doctor330.cloud.common.persistence.annotation.MyBatisDao;
import com.doctor330.cloud.modules.push.entity.BgUserPush;

/**
 * 关于消息推送的用户信息记录DAO接口
 * @author 郑源
 * @version 2016-11-02
 */
@MyBatisDao
public interface BgUserPushDao extends CrudDao<BgUserPush> {
	
}