package com.liujiadong.cms.dao;

import java.util.List;

import com.liujiadong.cms.bean.Article;
import com.liujiadong.cms.bean.Comment;

public interface CommentDao {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加评论
	 * @param comment
	 * @return
	 * @return: int
	 */
	int insert(Comment comment);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询评论
	 * @param article
	 * @return
	 * @return: List<Comment>
	 */
	List<Comment> selects(Article article);
	/**
	 * 
	 * @Title: updateArticle 
	 * @Description: 让评论数加一
	 * @param articleId
	 * @return
	 * @return: int
	 */
	int updateArticle(int articleId);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据评论数排名
	 * @param article
	 * @return
	 * @return: List<Comment>
	 */
	List<Article> select();
}
