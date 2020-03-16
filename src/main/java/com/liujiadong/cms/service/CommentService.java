package com.liujiadong.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.Article;
import com.liujiadong.cms.bean.Comment;

public interface CommentService {
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
	 * @Description: 查询当前评论
	 * @param article
	 * @return
	 * @return: List<Comment>
	 */
	PageInfo<Comment> selects(Article article,Integer pageNum);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据评论数排名
	 * @param article
	 * @return
	 * @return: List<Comment>
	 */
	PageInfo<Article> select(int pageNum);
}
