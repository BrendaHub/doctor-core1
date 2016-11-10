package com.doctor330.cloud.server.news;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor330.cloud.common.base.BaseService;
import com.doctor330.cloud.common.persistence.Page;
import com.doctor330.cloud.modules.cms.dao.ArticleDao;
import com.doctor330.cloud.modules.cms.dao.ArticleDataDao;
import com.doctor330.cloud.modules.cms.dao.CommentDao;
import com.doctor330.cloud.modules.cms.entity.Article;
import com.doctor330.cloud.modules.cms.entity.ArticleData;
import com.doctor330.cloud.modules.cms.entity.Comment;

@Service("newsService")
public class NewsServiceImpl extends BaseService implements INewsService {

	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ArticleDataDao articleDataDao;
	@Autowired
	private CommentDao commentDao;

	@Override
	public String getNewsList(String orderBy, Integer pageNo, Integer pageSize) {

		// 返回值的定义
		ArrayList<Map<String, Object>> articleReturnList = new ArrayList<Map<String, Object>>();
		// 查询条件的定义
		Article query = new Article();
		// 分页条件
		Page<Article> page = new Page<Article>();
		if (pageNo != null && pageSize != null) {
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
		}
		// 排序条件
		if (orderBy != null && orderBy.length() > 0 && (orderBy.contains("desc") || orderBy.contains("asc"))) {
			page.setOrderBy(orderBy);
		}
		query.setPage(page);
		// 获取资讯列表
		List<Article> articleList = articleDao.findAllList(query);
		for (Article article : articleList) {
			Map<String, Object> articleMap = new HashMap<String, Object>();
			articleMap.put("title", article.getTitle() == null ? "" : article.getTitle()); // 资讯标题
			articleMap.put("updateDate", article.getUpdateDate());// 资讯更新时间
			articleMap.put("articleId", article.getId());// 资讯ID
			articleMap.put("description", article.getDescription() == null ? "" : article.getDescription());// 资讯摘要
			articleMap.put("hits", article.getHits());// 资讯点击量
			articleMap.put("keywords", article.getKeywords() == null ? "" : article.getKeywords());// 资讯关键字
			articleMap.put("image", article.getImage() == null ? "" : article.getImage());// 资讯关键字
			articleMap.put("collectionCount", 0);// 资讯关键字
			ArticleData articleData = articleDataDao.get(article.getId());
			articleMap.put("source", articleData.getCopyfrom());// 资讯来源
			articleReturnList.add(articleMap);
		}
		return this.getJsonString(articleReturnList);
	}

	@Override
	public String getNewsDetail(String newsId) {

		Map<String, Object> articleMap = new HashMap<String, Object>();
		Article article = articleDao.get(newsId);
		ArticleData articleData = articleDataDao.get(newsId);
		if (articleData == null)
			return "";
		articleMap.put("content", articleData.getContent());// 资讯内容
		articleMap.put("title", article.getTitle());// 资讯标题
		articleMap.put("updateDate", article.getUpdateDate());// 资讯更新时间
		articleMap.put("allowComment", articleData.getAllowComment() == null ? "" : articleData.getAllowComment());// 是否允许评论
		return this.getJsonString(articleMap);
	}

	@Override
	public String getNewsCommentsList(String newsId, Integer pageNo, Integer pageSize) {

		// 返回值的定义
		ArrayList<Map<String, Object>> commentReturnList = new ArrayList<Map<String, Object>>();
		// 查询条件的定义
		Comment query = new Comment();
		// 分页条件
		Page<Comment> page = new Page<Comment>();
		if (pageNo != null && pageSize != null) {
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
		}
		query.setPage(page);
		query.setContentId(newsId);
		List<Comment> commentList = commentDao.findListByContentId(query);
		for (Comment comment : commentList) {
			Map<String, Object> commentMap = new HashMap<String, Object>();
			commentMap.put("name", comment.getName() == null ? "" : comment.getName());// 评论人姓名
			commentMap.put("time", comment.getAuditDate());// 评论时间
			commentMap.put("content", comment.getContent() == null ? "" : comment.getContent());// 评论内容
			commentReturnList.add(commentMap);
		}
		return this.getJsonString(commentReturnList);
	}

}
