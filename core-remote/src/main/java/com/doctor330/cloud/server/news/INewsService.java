package com.doctor330.cloud.server.news;

/**
 * @description 资讯服务
 * @date 创建时间：2016年10月24日 下午16:58:00
 * @author 郑源
 * @version 2.0
 * @parameter
 * @since
 * @return
 */
public interface INewsService {

	/**
	 * @description 获取所有资讯列表
	 * @author 郑源
	 * @date 创建时间：2016年10月24日 下午16:58:00
	 * @version 2.0
	 * @param orderBy 标准查询有效， 实例： updatedate desc, name asc
	 * @param pageNo 当前页
	 * @param pageSize 页面大小
	 * @return
	 */
	public String getNewsList(String orderBy,Integer pageNo,Integer pageSize);

	/**
	 * @description 获取所有资讯列表
	 * @author 郑源
	 * @date 创建时间：2016年10月24日 下午16:58:00
	 * @version 2.0
	 * @param newsId 资讯ID
	 * @since
	 * @return
	 */
	public String getNewsDetail(String newsId);
	
	/**
	 * @description 更加资讯ID获取所有评论列表
	 * @author 郑源
	 * @date 创建时间：2016年10月27日 下午15:38:00
	 * @version 2.0
	 * @param newsId 资讯ID
	 * @param pageNo 当前页
	 * @param pageSize 页面大小
	 * @since
	 * @return
	 */
	public String getNewsCommentsList(String newsId,Integer pageNo,Integer pageSize);
}
