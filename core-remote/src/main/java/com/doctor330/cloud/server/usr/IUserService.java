package com.doctor330.cloud.server.usr;

public interface IUserService {

	/**
	 * @description 获取所有资讯列表
	 * @author 郑源
	 * @date 创建时间：2016年10月24日 下午16:58:00
	 * @version 2.0
	 * @param orderBy 排序
	 * @param pageNo 当前页
	 * @param pageSize 页面大小
	 * @return
	 */
	public String getBigShotList(String orderBy,Integer pageNo,Integer pageSize);
	
	/**
	 * @description 获取所有资讯列表
	 * @author 郑源
	 * @date 创建时间：2016年10月24日 下午16:58:00
	 * @version 2.0
	 * @param userID 用户ID
	 * @return
	 */
	public String getBigShotDetail(Integer userID);
	
	/**
	 * @description 添加用户信息
	 * @author 郑源
	 * @date 创建时间：2016年11月5日 下午11:58:00
	 * @version 2.0
	 * @param userInfo
	 * @return
	 */
	public String addUser(String userInfo);
}
